package com.pfc2.weather.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "WEATHER_HISTORY")
@Table(indexes = {
        @Index(name = "fn_lat", columnList = "lat"),
        @Index(name = "fn_lon", columnList = "lon")
})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherHistory implements Serializable {
    @Id
    UUID id;

    @Column(nullable = false)
    Double lat;

    @Column(nullable = false)
    Double lon;

    String weather;

    @Column(name = "TEMP_MIN")
    Double tempMin;

    @Column(name = "TEMP_MAX")
    Double tempMax;

    Double humidity;

    LocalDateTime created;
}
