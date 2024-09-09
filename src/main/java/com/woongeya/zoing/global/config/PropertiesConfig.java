package com.woongeya.zoing.global.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.woongeya.zoing.global.jwt.config.JwtProperties;

@Configuration
@EnableConfigurationProperties({JwtProperties.class})
public class PropertiesConfig {
}
