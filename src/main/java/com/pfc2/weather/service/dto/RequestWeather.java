package com.pfc2.weather.service.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record RequestWeather(@NotNull Double lat, @NotNull Double lon) implements Serializable {
}
