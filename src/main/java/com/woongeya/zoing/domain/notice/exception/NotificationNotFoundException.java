package com.woongeya.zoing.domain.notice.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class NotificationNotFoundException extends ZoingException {

    public static final ZoingException EXCEPTION = new NotificationNotFoundException();

    public NotificationNotFoundException() {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
