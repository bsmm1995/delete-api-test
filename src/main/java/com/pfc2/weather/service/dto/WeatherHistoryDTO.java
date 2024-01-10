package com.pfc2.weather.service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record WeatherHistoryDTO(UUID id, Double lat, Double lon, String weather, Double tempMin, Double tempMax,
                                Double humidity, LocalDateTime created) {
}
