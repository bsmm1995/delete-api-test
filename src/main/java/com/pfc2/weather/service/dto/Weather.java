package com.pfc2.weather.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Weather implements Serializable {
    Integer id;
    String main;
    String description;
    String icon;
}
