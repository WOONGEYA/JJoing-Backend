package com.woongeya.zoing.domain.follow.exception;

import com.woongeya.zoing.domain.like.exception.AlreadyLikeException;
import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class AlreadyFollowException extends ZoingException {

    public static final ZoingException EXCEPTION = new AlreadyFollowException();

    public AlreadyFollowException() { super(ErrorCode.ALREADY_LIKE); }
}
