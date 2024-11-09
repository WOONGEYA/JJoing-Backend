package com.woongeya.zoing.domain.project.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class IsNotWriterException extends JJoingException {

    public IsNotWriterException() {
        super(HttpStatus.FORBIDDEN, "작성자가 아닙니다.");
    }
}
