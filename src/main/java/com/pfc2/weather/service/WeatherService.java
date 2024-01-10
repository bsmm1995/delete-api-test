package com.pfc2.weather.service;

import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;

public interface WeatherService {
    ResponseWeather getCurrentWeatherData(RequestWeather data);
}
