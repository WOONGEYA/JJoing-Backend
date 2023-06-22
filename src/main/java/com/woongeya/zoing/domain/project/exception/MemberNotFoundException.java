package com.woongeya.zoing.domain.project.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class MemberNotFoundException extends ZoingException{

    public static final ZoingException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
