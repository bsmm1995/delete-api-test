package com.pfc2.weather.service.dto;

public record ResponseWeather(String weather, Double tempMin, Double tempMax, Double humidity) {
}
