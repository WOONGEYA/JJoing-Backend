package com.woongeya.zoing.domain.follow.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class AlreadyFollowException extends JJoingException {

    public static final JJoingException EXCEPTION = new AlreadyFollowException();

    public AlreadyFollowException() { super(ErrorCode.ALREADY_LIKE); }
}
