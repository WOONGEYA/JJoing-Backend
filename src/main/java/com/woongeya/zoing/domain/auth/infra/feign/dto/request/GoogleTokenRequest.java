package com.woongeya.zoing.domain.auth.infra.feign.dto.request;

import com.woongeya.zoing.global.config.credential.AuthCredentials;

public record GoogleTokenRequest (
    String code,
    String clientId,
    String clientSecret,
    String redirectUri,
    String grantType
) {
    public static GoogleTokenRequest from(String code, AuthCredentials authCredentials) {
        return new GoogleTokenRequest(code, authCredentials.clientId(), authCredentials.clientSecret(),
            authCredentials.redirectUri(), "authorization_code");
    }
}
