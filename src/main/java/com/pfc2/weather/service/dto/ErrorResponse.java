package com.pfc2.weather.service.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public record ErrorResponse(HttpStatus code, List<String> erros) implements Serializable {
}
