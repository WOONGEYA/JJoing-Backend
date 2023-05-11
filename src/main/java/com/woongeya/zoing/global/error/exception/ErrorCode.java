package com.woongeya.zoing.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_JWT(403, "TOKEN-403-1", "Expired Jwt"),
    INVALID_JWT(403, "TOKEN-403-2", "Invalid Jwt"),
    FAILED_AUTHENTICATION(401, "AUTHENTICATION-401-1", "Failed_Authentication"),
    ;

    private final int status;
    private final String code;
    private final String message;
}
