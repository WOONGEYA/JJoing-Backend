package com.woongeya.zoing.global.jwt.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class ExpiredJwtException extends ZoingException {

    public static final ZoingException EXCEPTION = new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
