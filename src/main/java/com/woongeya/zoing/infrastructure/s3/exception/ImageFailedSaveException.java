package com.woongeya.zoing.infrastructure.s3.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class ImageFailedSaveException extends JJoingException {

    public ImageFailedSaveException() {
        super(HttpStatus.FAILED_DEPENDENCY, "이미지를 저장하지 못했습니다.");
    }
}
