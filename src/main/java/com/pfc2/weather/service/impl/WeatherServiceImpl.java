package com.pfc2.weather.service.impl;

import com.pfc2.weather.domain.WeatherHistory;
import com.pfc2.weather.reporitory.OpenWeatherMapClient;
import com.pfc2.weather.reporitory.WeatherHistoryRepository;
import com.pfc2.weather.service.WeatherService;
import com.pfc2.weather.service.dto.ApiOpenWeatherMapRes;
import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;
import com.pfc2.weather.service.mapper.WeatherMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {
    private final OpenWeatherMapClient weatherMapApi;
    private final WeatherHistoryRepository historyRepository;
    private final String appId;

    public WeatherServiceImpl(OpenWeatherMapClient weatherMapApi, WeatherHistoryRepository historyRepository, @Value("${app.secrets.open-weather.app-id}") String appid) {
        this.weatherMapApi = weatherMapApi;
        this.historyRepository = historyRepository;
        this.appId = appid;
    }

    @Override
    @Transactional
    public ResponseWeather getCurrentWeatherData(RequestWeather data) {
        WeatherHistory weatherHistory = null;
        var optional = historyRepository.findByLatAndLon(data.lat(), data.lon());
        if (optional.isPresent()) {
            if (optional.get().getCreated().isAfter(LocalDateTime.now().minusMinutes(10))) {
                weatherHistory = optional.get();
                log.info("Registro obtenido desde la DB: {}", weatherHistory);
            } else {
                log.info("Se elimina el registro con ID {}", optional.get().getId());
                historyRepository.deleteById(optional.get().getId());
            }
        }
        if (weatherHistory == null) {
            ApiOpenWeatherMapRes response = weatherMapApi.getCurrentWeatherData(data.lat(), data.lon(), appId);
            log.info("Se consume API de tercero: {}", response);
            weatherHistory = WeatherMapper.INSTANCE.toWeatherHistory(response);
            historyRepository.save(weatherHistory);
        }
        return WeatherMapper.INSTANCE.toResponseWeather(weatherHistory);
    }

    @Override
    public List<WeatherHistoryDTO> getWeatherHistory() {
        return historyRepository.findAll().stream()
                .map(WeatherMapper.INSTANCE::toWeatherHistoryDTO)
                .toList();
    }
}
