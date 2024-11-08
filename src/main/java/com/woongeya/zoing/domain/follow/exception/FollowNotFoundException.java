package com.woongeya.zoing.domain.follow.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class FollowNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new FollowNotFoundException();

    public FollowNotFoundException () {
        super(ErrorCode.FOLLOW_NOT_FOUND);
    }
}
