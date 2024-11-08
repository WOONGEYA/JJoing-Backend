package com.woongeya.zoing.infrastructure.s3.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class ImageNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new ImageNotFoundException();

    public ImageNotFoundException() {
        super(ErrorCode.IMAGE_FAILED_SAVE);
    }
}
