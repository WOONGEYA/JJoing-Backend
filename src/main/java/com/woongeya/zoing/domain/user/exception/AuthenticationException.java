package com.woongeya.zoing.domain.user.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class AuthenticationException extends JJoingException {

    public static final JJoingException EXCEPTION = new AuthenticationException();

    public AuthenticationException() {
        super(ErrorCode.FAILED_AUTHENTICATION);
    }
}
