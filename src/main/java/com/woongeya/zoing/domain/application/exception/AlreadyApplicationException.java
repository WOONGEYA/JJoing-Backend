package com.woongeya.zoing.domain.application.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class AlreadyApplicationException extends ZoingException {

    public static final ZoingException EXCEPTION = new AlreadyApplicationException();

    public AlreadyApplicationException() {
        super(ErrorCode.ALREADY_APPLICATION);
    }
}
