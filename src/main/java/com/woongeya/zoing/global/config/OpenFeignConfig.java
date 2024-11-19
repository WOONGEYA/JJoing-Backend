package com.woongeya.zoing.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.woongeya.zoing.domain.auth.infra.feign")
public class OpenFeignConfig {
}
