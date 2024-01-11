package com.pfc2.weather.service;

import com.pfc2.weather.service.dto.TokenResponse;

public interface LoginService {
    TokenResponse generateToken();
}
