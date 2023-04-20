package com.woongeya.zoing.domain.auth.domain;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String id;

    private String token;

    private String role;

    @TimeToLive
    private long ttl;

    public RefreshToken update(String token, long ttl) {
        this.token = token;
        this.ttl = ttl;
        return this;
    }
}
