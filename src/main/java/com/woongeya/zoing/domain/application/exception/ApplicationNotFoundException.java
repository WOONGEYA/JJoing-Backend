package com.woongeya.zoing.domain.application.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class ApplicationNotFoundException extends ZoingException {

    public static final ZoingException EXCEPTION = new ApplicationNotFoundException();

    public ApplicationNotFoundException () {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
