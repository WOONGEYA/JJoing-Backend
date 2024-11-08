package com.woongeya.zoing.domain.application.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class AlreadyApplicationException extends JJoingException {

    public static final JJoingException EXCEPTION = new AlreadyApplicationException();

    public AlreadyApplicationException() {
        super(ErrorCode.ALREADY_APPLICATION);
    }
}
