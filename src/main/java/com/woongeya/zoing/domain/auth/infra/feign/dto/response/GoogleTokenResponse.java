package com.woongeya.zoing.domain.auth.infra.feign.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GoogleTokenResponse(
    @JsonProperty("access_token")
    String accessToken
) {
}
