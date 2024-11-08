package com.woongeya.zoing.domain.comment.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class ReCommentNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new CommentNotFoundException();

    public ReCommentNotFoundException() {
        super(ErrorCode.RECOMMENT_NOT_FOUND);
    }
}

