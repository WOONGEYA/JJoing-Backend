package com.woongeya.zoing.domain.post.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class PostNotFoundException extends ZoingException {

    public static final ZoingException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}