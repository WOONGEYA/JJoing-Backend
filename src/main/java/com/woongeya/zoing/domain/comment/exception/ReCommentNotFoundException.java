package com.woongeya.zoing.domain.comment.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class ReCommentNotFoundException extends ZoingException {

    public static final ZoingException EXCEPTION = new CommentNotFoundException();

    public ReCommentNotFoundException() {
        super(ErrorCode.RECOMMENT_NOT_FOUND);
    }
}

