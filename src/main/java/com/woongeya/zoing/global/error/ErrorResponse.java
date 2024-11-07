package com.woongeya.zoing.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;

    @Override
    public String toString() {
        return "{\n" +
                "\t\"status\": " + status +
                ",\n\t\"message\": \"" + message + '\"' +
                "\n}";
    }
}
