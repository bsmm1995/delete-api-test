package com.pfc2.weather.controller;

import com.pfc2.weather.service.WeatherService;
import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @PostMapping
    ResponseEntity<ResponseWeather> getCurrentWeatherData(@RequestBody RequestWeather data) {
        log.info("Endpoint to get Current Weather Data: {}", data);
        return ResponseEntity.ok(weatherService.getCurrentWeatherData(data));
    }
}
