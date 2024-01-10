package com.pfc2.weather.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainDTO implements Serializable {
    Double temp;

    @JsonProperty("feels_like")
    Double feelsLike;

    @JsonProperty("temp_min")
    Double tempMin;

    @JsonProperty("temp_max")
    Double tempMax;

    Double pressure;
    Double humidity;

    @JsonProperty("sea_level")
    Double seaLevel;

    @JsonProperty("grnd_level")
    Double grndLevel;
}
