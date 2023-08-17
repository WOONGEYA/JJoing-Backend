package com.woongeya.zoing.domain.like.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class AlreadyLikeException extends ZoingException {

    public static final ZoingException EXCEPTION = new AlreadyLikeException();

    public AlreadyLikeException() { super(ErrorCode.ALREADY_LIKE); }
}
