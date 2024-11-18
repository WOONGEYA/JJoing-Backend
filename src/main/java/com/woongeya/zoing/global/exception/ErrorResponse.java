package com.woongeya.zoing.global.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse (
    HttpStatus status,
    String message
) {
    @Override
    public String toString() {
        return "{\n" +
                "\nt\"status\": " + status +
                ",\n\t\"message\": \"" + message + '\"' +
                "\n}";
    }
}
