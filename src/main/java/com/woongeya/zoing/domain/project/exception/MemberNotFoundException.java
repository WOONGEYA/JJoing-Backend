package com.woongeya.zoing.domain.project.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class MemberNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
