package com.pfc2.weather.reporitory;

import com.pfc2.weather.service.dto.ApiOpenWeatherMapRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openWeatherMapClient", url = "${services.open-weather-map}")
public interface OpenWeatherMapClient {
    @GetMapping
    ApiOpenWeatherMapRes getCurrentWeatherData(@RequestParam Double lat, @RequestParam Double lon, @RequestParam String appid);
}
