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
    FAILED_AUTHENTICATION(401, "AUTHENTICATION-401-1", "Failed Authentication"),
    NOT_MEISTER_MEMBER(401, "AUTHENTICATION-401-2", "Not Meister Member"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    PROJECT_NOT_FOUND(404, "PROJECT-404-1", "Project Not Found"),
    APPLICATION_NOT_FOUND(404, "APPLICATION-404-1", "Application Not Found"),
    IS_NOT_WRITER(403, "WRITER-403-1", "Is Not Writer"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    ;

    private final int status;
    private final String code;
    private final String message;
}
