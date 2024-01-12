package com.pfc2.weather.controller;

import com.pfc2.weather.service.LoginService;
import com.pfc2.weather.service.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Login", description = "APi to generate a token in oauth0.")
public class LoginController {
    private final LoginService loginService;

    @Operation(summary = "Generate a token to consume API")
    @GetMapping("/token")
    ResponseEntity<TokenResponse> getJwtToken() {
        log.info("Endpoint to get JWT Token");
        return ResponseEntity.ok(loginService.generateToken());
    }
}
