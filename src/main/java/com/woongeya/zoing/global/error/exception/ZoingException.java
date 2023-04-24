package com.woongeya.zoing.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ZoingException extends RuntimeException {

    private final ErrorCode errorCode;
}
