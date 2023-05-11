package com.woongeya.zoing.domain.user.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class AuthenticationException extends ZoingException {

    public static final ZoingException EXCEPTION = new AuthenticationException();

    public AuthenticationException() {
        super(ErrorCode.FAILED_AUTHENTICATION);
    }
}
