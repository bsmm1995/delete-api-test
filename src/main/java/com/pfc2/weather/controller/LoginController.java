package com.pfc2.weather.controller;

import com.pfc2.weather.service.LoginService;
import com.pfc2.weather.service.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/token")
    ResponseEntity<TokenResponse> getJwtToken() {
        log.info("Endpoint to get JWT Token");
        return ResponseEntity.ok(loginService.generateToken());
    }
}
