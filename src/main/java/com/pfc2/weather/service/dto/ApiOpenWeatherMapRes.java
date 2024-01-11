package com.pfc2.weather.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiOpenWeatherMapRes implements Serializable {
    private RequestWeather coord;
    private List<Weather> weather;
    MainDTO main;
}
