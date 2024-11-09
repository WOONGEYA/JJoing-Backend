package com.woongeya.zoing.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class JJoingException extends RuntimeException {

    private final HttpStatus status;
    private final String message;
}
