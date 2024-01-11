package com.pfc2.weather.service.impl;

import com.pfc2.weather.reporitory.TokenLoginClient;
import com.pfc2.weather.service.LoginService;
import com.pfc2.weather.service.dto.TokenRequest;
import com.pfc2.weather.service.dto.TokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    private final TokenLoginClient tokenLoginClient;
    private final TokenRequest tokenRequest;

    public LoginServiceImpl(TokenLoginClient tokenLoginClient,
                            @Value("${app.secrets.oauth.client-id}") String clientId,
                            @Value("${app.secrets.oauth.client-secret}") String clientSecret,
                            @Value("${app.secrets.oauth.audience}") String audience,
                            @Value("${app.secrets.oauth.grant-type}") String grantType) {
        this.tokenLoginClient = tokenLoginClient;
        this.tokenRequest = new TokenRequest(clientId, clientSecret, audience, grantType);
    }

    @Override
    public TokenResponse generateToken() {
        return tokenLoginClient.generateJwtToken(tokenRequest);
    }
}
