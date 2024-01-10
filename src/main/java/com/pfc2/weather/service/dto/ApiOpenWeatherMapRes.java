package com.pfc2.weather.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiOpenWeatherMapRes implements Serializable {
    RequestWeather coord;
    List<Weather> weather;
    String base;
    MainDTO main;
    Integer visibility;
    Wind wind;
    Map<String, Double> rain;
    Long dt;
    Sys sys;
    Long timezone;
    Long id;
    String name;
    Integer cod;
}
