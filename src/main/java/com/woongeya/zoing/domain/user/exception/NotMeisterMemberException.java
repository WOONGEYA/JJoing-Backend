package com.woongeya.zoing.domain.user.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class NotMeisterMemberException extends JJoingException {

    public static final JJoingException EXCEPTION = new NotMeisterMemberException();

    public NotMeisterMemberException() {
        super(ErrorCode.NOT_MEISTER_MEMBER);
    }
}
