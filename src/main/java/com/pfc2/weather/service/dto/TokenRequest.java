package com.pfc2.weather.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenRequest(@JsonProperty("client_id") String clientId,
                           @JsonProperty("client_secret") String clientSecret,
                           @JsonProperty("audience") String audience,
                           @JsonProperty("grant_type") String grantType) {
}
