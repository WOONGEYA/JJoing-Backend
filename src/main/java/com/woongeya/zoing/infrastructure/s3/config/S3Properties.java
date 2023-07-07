package com.woongeya.zoing.infrastructure.s3.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("cloud.aws")
public class S3Properties {

    private String accessKey;
    private String secretKey;
    private String bucket;
}
