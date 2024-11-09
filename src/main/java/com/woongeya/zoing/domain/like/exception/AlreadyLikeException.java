package com.woongeya.zoing.domain.like.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class AlreadyLikeException extends JJoingException {

    public AlreadyLikeException(Long id) {
        super(HttpStatus.BAD_REQUEST, String.format("%s의 아이디를 가진 좋아요가 이미 존재합니다.", id));
    }
}
