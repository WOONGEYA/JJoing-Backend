package com.woongeya.zoing.infrastructure.s3.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class ImageFailedSaveException extends JJoingException {

    public static final JJoingException EXCEPTION = new ImageFailedSaveException();

    public ImageFailedSaveException() {
        super(ErrorCode.IMAGE_FAILED_SAVE);
    }
}
