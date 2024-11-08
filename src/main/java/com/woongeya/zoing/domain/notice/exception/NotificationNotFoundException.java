package com.woongeya.zoing.domain.notice.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class NotificationNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new NotificationNotFoundException();

    public NotificationNotFoundException() {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
