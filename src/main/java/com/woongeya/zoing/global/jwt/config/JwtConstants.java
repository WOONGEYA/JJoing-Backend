package com.woongeya.zoing.global.jwt.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JwtConstants {

    ACCESS_KEY("access_token"),
    REFRESH_KEY("refresh_token"),
    EMPTY(" "),
    TYPE("type"),
    ROLE("role"),
    AUTH_ID("auth_id"),
    ROOT("ROOT");

    public String message;
}
