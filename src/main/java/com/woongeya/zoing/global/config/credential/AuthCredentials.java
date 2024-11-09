package com.woongeya.zoing.global.config.credential;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.security.oauth2.client.registration.google")
public record AuthCredentials (
    String clientId,
    String clientSecret,
    String redirectUri
) {
}
