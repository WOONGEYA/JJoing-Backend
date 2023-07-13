package com.woongeya.zoing.domain.auth.service;

import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.global.jwt.config.JwtConstants;
import com.woongeya.zoing.global.jwt.dto.TokenResponseDto;
import com.woongeya.zoing.global.jwt.util.JwtProvider;
import com.woongeya.zoing.global.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtUtil jwtUtil;
    private final JwtProvider jwtProvider;
    private final UserFacade userFacade;

    public TokenResponseDto execute(String token) {
        String email = jwtUtil.getJws(jwtUtil.parseToken(token)).getBody().get(JwtConstants.AUTH_ID.message).toString();
        User user = userFacade.getUserByEmail(email);

        return TokenResponseDto.builder()
                .accessToken(jwtProvider.generateAccessToken(user.getEmail(), user.getAuthority().toString()))
                .build();
    }
}
