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
    USER_NOT_LOGIN(403, "USER-403-1", "User Not Login"),
    FAILED_AUTHENTICATION(401, "AUTHENTICATION-401-1", "Failed Authentication"),
    NOT_MEISTER_MEMBER(401, "AUTHENTICATION-401-2", "Not Meister Member"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    PROJECT_NOT_FOUND(404, "PROJECT-404-1", "Project Not Found"),
    MEMBER_NOT_FOUND(404, "MEMBER-404-1", "Member Not Found"),
    APPLICATION_NOT_FOUND(404, "APPLICATION-404-1", "Application Not Found"),
    ALREADY_APPLICATION(400, "APPLICATION-400-1", "Already Application This Project"),
    FOLLOW_NOT_FOUND(404, "FOLLOW-404-1", "Follow Not Found"),
    ALREADY_FOLLOW(400, "FOLLOW-400-1", "Already Follow"),
    IS_NOT_WRITER(403, "WRITER-403-1", "Is Not Writer"),
    YOU_DONT_LIKE_BEFORE(400, "LIKE-400-1", "You Dont Like Before"),
    ALREADY_LIKE(400, "LIKE-400-1", "Already Like This Project"),
    NON_EXISTENT_PROJECT(404, "LiKE-404-1", "Non Existent Project"),
    NOTIFICATION_NOT_FOUND(404, "NOTIFICATION-404-1", "Notification Not Found"),

    // S3
    IMAGE_FAILED_SAVE(424, "IMAGE-424-1", "Image Failed Save"),
    IMAGE_NOT_FOUND(404, "IMAGE-404-1", "Image Not Found"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    ;

    private final int status;
    private final String code;
    private final String message;
}
