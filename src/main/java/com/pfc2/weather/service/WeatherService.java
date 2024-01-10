package com.pfc2.weather.service;

import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;

import java.util.List;

public interface WeatherService {
    ResponseWeather getCurrentWeatherData(RequestWeather data);

    List<WeatherHistoryDTO> getWeatherHistory();
}
