package com.pfc2.weather.reporitory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class HttpClientsFactory {
    private final OpenWeatherMapClient openWeatherMapClient;
    private final TokenLoginClient tokenLoginClient;
}
