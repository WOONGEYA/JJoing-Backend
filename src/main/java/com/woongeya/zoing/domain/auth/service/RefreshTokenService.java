package com.woongeya.zoing.domain.auth.service;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.auth.domain.Token;
import com.woongeya.zoing.domain.auth.presetation.dto.response.TokenResponse;
import com.woongeya.zoing.domain.auth.service.implementation.TokenProvider;
import com.woongeya.zoing.domain.auth.util.BearerTokenExtractor;
import com.woongeya.zoing.domain.auth.util.JwtParser;
import com.woongeya.zoing.domain.user.UserFacade;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtParser jwtParser;
    private final TokenProvider tokenProvider;
    private final AuthRepository authRepository;

    public Token execute(String bearer) {
        String refreshToken = BearerTokenExtractor.extract(bearer);
        Long userId = jwtParser.getIdFromJwt(refreshToken);
        String accessToken = tokenProvider.createAccessToken(userFacade.getUserById(userId));

        return new Token(accessToken, refreshToken);
    }
}
