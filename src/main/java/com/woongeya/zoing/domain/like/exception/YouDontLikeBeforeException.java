package com.woongeya.zoing.domain.like.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class YouDontLikeBeforeException extends JJoingException {

    public static final JJoingException EXCEPTION = new YouDontLikeBeforeException();

    public YouDontLikeBeforeException () { super(ErrorCode.YOU_DONT_LIKE_BEFORE); }
}
