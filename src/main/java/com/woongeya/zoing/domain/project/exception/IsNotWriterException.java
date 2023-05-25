package com.woongeya.zoing.domain.project.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class IsNotWriterException extends ZoingException {

    private static final ZoingException EXCEPTION = new IsNotWriterException();

    public IsNotWriterException() {
        super(ErrorCode.IS_NOT_WRITER);
    }
}
