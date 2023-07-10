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

    private S3 s3;
    private Credentials credentials;

    @Getter
    @Setter
    public static class S3 {
        private String bucket;
    }

    @Getter
    @Setter
    public static class Credentials {
        private String accessKey;
        private String secretKey;
    }

    public String getBucket() {
        return s3.getBucket();
    }

    public String getAccessKey() {
        return credentials.getAccessKey();
    }

    public String getSecretKey() {
        return credentials.getSecretKey();
    }
}
