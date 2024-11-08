package com.woongeya.zoing.domain.like.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class NonExistentProjectException extends JJoingException {

    public static final JJoingException EXCEPTION = new NonExistentProjectException();
    public NonExistentProjectException() { super(ErrorCode.NON_EXISTENT_PROJECT); }
}
