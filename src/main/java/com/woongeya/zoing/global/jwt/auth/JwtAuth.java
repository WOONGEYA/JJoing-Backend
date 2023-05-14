package com.woongeya.zoing.global.jwt.auth;

import com.woongeya.zoing.global.jwt.config.JwtConstants;
import com.woongeya.zoing.global.jwt.exception.InvalidJwtException;
import com.woongeya.zoing.global.jwt.util.JwtUtil;
import com.woongeya.zoing.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtAuth {

    private final JwtUtil jwtUtil;
    private final AuthDetailsService authDetailsService;

    public Authentication authentication(String token) {
        Claims claims = jwtUtil.getJws(token).getBody();

        if(isNotAccessToken(token)) {
            throw InvalidJwtException.EXCEPTION;
        }

        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.get(JwtConstants.AUTH_ID.message).toString());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private boolean isNotAccessToken(String token) {
        if (token.isEmpty()) {
            throw InvalidJwtException.EXCEPTION;
        }

        String role = jwtUtil.getJws(token).getHeader().get(JwtConstants.TYPE.message).toString();
        return !role.equals(JwtConstants.ACCESS_KEY.message);
    }
}
