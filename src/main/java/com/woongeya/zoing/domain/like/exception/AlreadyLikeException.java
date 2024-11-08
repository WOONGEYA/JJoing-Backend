package com.woongeya.zoing.domain.like.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class AlreadyLikeException extends JJoingException {

    public static final JJoingException EXCEPTION = new AlreadyLikeException();

    public AlreadyLikeException() { super(ErrorCode.ALREADY_LIKE); }
}
