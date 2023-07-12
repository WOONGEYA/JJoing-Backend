package com.woongeya.zoing.domain.auth.service;

import com.woongeya.zoing.global.config.propertise.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2GoogleLinkService {

    private static final String baseUrl = "https://accounts.google.com/o/oauth2/auth?";
    private final AuthProperties authProperties;

    public String execute() {
        return String.format(
                baseUrl +
                "?client_id=%s&redirect_uri=%s&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile",
                authProperties.getClientId(),
                authProperties.getRedirectUri()
        );
    }
}
