package com.pfc2.weather.service.dto;

import jakarta.validation.constraints.NotNull;

public record RequestWeather(@NotNull Double lat, @NotNull Double lon) {
}
