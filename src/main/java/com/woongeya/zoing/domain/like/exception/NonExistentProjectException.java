package com.woongeya.zoing.domain.like.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class NonExistentProjectException extends ZoingException {

    public static final ZoingException EXCEPTION = new NonExistentProjectException();
    public NonExistentProjectException() { super(ErrorCode.NON_EXISTENT_PROJECT); }
}
