package com.woongeya.zoing.global.jwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import lombok.Getter;

@Getter
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private final String header;
    private final String secret;
    private final Long accessExp;
    private final Long refreshExp;
    private final String prefix;

    @ConstructorBinding
    public JwtProperties(String header, String secret, Long accessExp, Long refreshExp, String prefix) {
        this.header = header;
        this.secret = secret;
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
        this.prefix = prefix;
    }
}
