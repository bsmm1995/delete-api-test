package com.pfc2.weather.controller;

import com.pfc2.weather.service.WeatherService;
import com.pfc2.weather.service.dto.RequestWeather;
import com.pfc2.weather.service.dto.ResponseWeather;
import com.pfc2.weather.service.dto.WeatherHistoryDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @PostMapping
    ResponseEntity<ResponseWeather> getCurrentWeatherData(@RequestBody @Valid RequestWeather data) {
        log.info("Endpoint to get Current Weather Data: {}", data);
        return ResponseEntity.ok(weatherService.getCurrentWeatherData(data));
    }

    @GetMapping("/history")
    ResponseEntity<List<WeatherHistoryDTO>> getWeatherHistory() {
        log.info("Endpoint to get Weather History");
        return ResponseEntity.ok(weatherService.getWeatherHistory());
    }
}
