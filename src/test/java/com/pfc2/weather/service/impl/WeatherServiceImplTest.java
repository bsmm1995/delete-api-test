package com.pfc2.weather.service.impl;

import com.pfc2.weather.domain.WeatherHistory;
import com.pfc2.weather.reporitory.HttpClientsFactory;
import com.pfc2.weather.reporitory.OpenWeatherMapClient;
import com.pfc2.weather.reporitory.TokenLoginClient;
import com.pfc2.weather.reporitory.WeatherHistoryRepository;
import com.pfc2.weather.service.dto.RequestWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {
    @InjectMocks
    private WeatherServiceImpl weatherService;
    @Mock
    private HttpClientsFactory clientsFactory;
    @Mock
    private WeatherHistoryRepository historyRepository;
    @Mock
    private OpenWeatherMapClient openWeatherMapClient;
    @Mock
    private TokenLoginClient tokenLoginClient;

    private WeatherHistory weatherHistory;

    @BeforeEach
    void setUp() {
        weatherHistory = new WeatherHistory();
        weatherHistory.setId(UUID.randomUUID());
        weatherHistory.setLat(10.0);
        weatherHistory.setLon(10.0);
        weatherHistory.setWeather("Cloud");
        weatherHistory.setTempMin(15.0);
        weatherHistory.setTempMax(90.0);
        weatherHistory.setHumidity(50.0);
        weatherHistory.setCreated(LocalDateTime.now());
    }

    @Test
    void getCurrentWeatherData() {
        when(historyRepository.findByLatAndLon(any(), any())).thenReturn(Optional.of(weatherHistory));
        var result = weatherService.getCurrentWeatherData(new RequestWeather(10.0, 10.1));
        assertEquals(result.weather(), weatherHistory.getWeather());
    }

    @Test
    void getWeatherHistory() {
        when(historyRepository.findAll()).thenReturn(List.of(weatherHistory));
        var result = weatherService.getWeatherHistory();
        assertFalse(result.isEmpty());
    }
}