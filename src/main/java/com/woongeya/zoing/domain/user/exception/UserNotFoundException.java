package com.woongeya.zoing.domain.user.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class UserNotFoundException extends ZoingException {

    public final static UserNotFoundException EXCEPTION = new UserNotFoundException(ErrorCode.USER_NOT_FOUND);

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
