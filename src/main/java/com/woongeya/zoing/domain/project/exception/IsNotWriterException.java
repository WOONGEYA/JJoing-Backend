package com.woongeya.zoing.domain.project.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class IsNotWriterException extends JJoingException {

    private static final JJoingException EXCEPTION = new IsNotWriterException();

    public IsNotWriterException() {
        super(ErrorCode.IS_NOT_WRITER);
    }
}
