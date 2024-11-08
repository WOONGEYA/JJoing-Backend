package com.woongeya.zoing.domain.application.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class ApplicationNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new ApplicationNotFoundException();

    public ApplicationNotFoundException () {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
