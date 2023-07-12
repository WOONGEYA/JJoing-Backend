package com.woongeya.zoing.global.config.propertise;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("spring.security.oauth2.client.registration.google")
public class AuthProperties {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
