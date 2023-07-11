package com.woongeya.zoing.infrastructure.s3.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class ImageNotFoundException extends ZoingException{

    public static final ZoingException EXCEPTION = new ImageNotFoundException();

    public ImageNotFoundException() {
        super(ErrorCode.IMAGE_FAILED_SAVE);
    }
}
