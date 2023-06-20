package com.woongeya.zoing.domain.user.service;

import com.woongeya.zoing.domain.auth.domain.repository.RefreshTokenRepository;
import com.woongeya.zoing.global.jwt.config.JwtConstants;
import com.woongeya.zoing.global.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserLogoutService {

    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public String execute(String refreshToken) {
        String email = jwtUtil.getJws(jwtUtil.parseToken(refreshToken)).getBody().get(JwtConstants.AUTH_ID.message).toString();
        refreshTokenRepository.findById(email).ifPresent(refreshTokenRepository::delete);

        return email;
    }
}
