package com.woongeya.zoing.domain.auth.presetation.dto.response;

import com.woongeya.zoing.domain.auth.domain.Token;

public record TokenResponse (
    String accessToken,
    String refreshToken
) {

    public static TokenResponse from(Token token) {
        return new TokenResponse(token.accessToken(), token.refreshToken());
    }
}
