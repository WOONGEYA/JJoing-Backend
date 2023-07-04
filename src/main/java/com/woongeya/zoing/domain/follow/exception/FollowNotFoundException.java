package com.woongeya.zoing.domain.follow.exception;

import com.woongeya.zoing.domain.application.exception.ApplicationNotFoundException;
import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class FollowNotFoundException extends ZoingException {

    public static final ZoingException EXCEPTION = new FollowNotFoundException();

    public FollowNotFoundException () {
        super(ErrorCode.FOLLOW_NOT_FOUND);
    }
}
