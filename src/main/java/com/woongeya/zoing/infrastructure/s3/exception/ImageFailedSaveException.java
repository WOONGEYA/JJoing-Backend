package com.woongeya.zoing.infrastructure.s3.exception;

import com.woongeya.zoing.domain.user.exception.AuthenticationException;
import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class ImageFailedSaveException extends ZoingException {

    public static final ZoingException EXCEPTION = new ImageFailedSaveException();

    public ImageFailedSaveException() {
        super(ErrorCode.IMAGE_FAILED_SAVE);
    }
}
