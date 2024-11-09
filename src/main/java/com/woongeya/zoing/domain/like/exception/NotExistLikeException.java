package com.woongeya.zoing.domain.like.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class NotExistLikeException extends JJoingException {

    public NotExistLikeException() {
        super(HttpStatus.BAD_REQUEST, "좋아요가 존재하지 않습니다.");
    }
}
