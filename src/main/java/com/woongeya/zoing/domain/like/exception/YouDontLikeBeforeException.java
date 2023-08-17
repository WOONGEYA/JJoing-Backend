package com.woongeya.zoing.domain.like.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class YouDontLikeBeforeException extends ZoingException {

    public static final ZoingException EXCEPTION = new YouDontLikeBeforeException();

    public YouDontLikeBeforeException () { super(ErrorCode.YOU_DONT_LIKE_BEFORE); }
}
