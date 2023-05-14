package com.woongeya.zoing.global.security;

import com.woongeya.zoing.global.jwt.auth.JwtAuth;
import com.woongeya.zoing.global.jwt.auth.JwtFilter;
import com.woongeya.zoing.global.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtUtil jwtUtil;
    private final JwtAuth jwtAuth;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JwtFilter jwtFilter = new JwtFilter(jwtUtil, jwtAuth);
    }
}
