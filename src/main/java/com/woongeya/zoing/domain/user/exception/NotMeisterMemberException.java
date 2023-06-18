package com.woongeya.zoing.domain.user.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class NotMeisterMemberException extends ZoingException{

    public static final ZoingException EXCEPTION = new NotMeisterMemberException();

    public NotMeisterMemberException() {
        super(ErrorCode.NOT_MEISTER_MEMBER);
    }
}
