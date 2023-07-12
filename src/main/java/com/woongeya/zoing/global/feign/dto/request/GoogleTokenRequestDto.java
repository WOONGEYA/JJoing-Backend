package com.woongeya.zoing.global.feign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GoogleTokenRequestDto {

    private final String code;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String grantType = "authorization_code";
}
