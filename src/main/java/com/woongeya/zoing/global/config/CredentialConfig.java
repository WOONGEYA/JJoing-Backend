package com.woongeya.zoing.global.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.woongeya.zoing.global.config.credential.AuthCredentials;
import com.woongeya.zoing.global.config.credential.JwtCredentials;

@Configuration
@EnableConfigurationProperties({
	AuthCredentials.class, JwtCredentials.class
})
public class CredentialConfig {
}
