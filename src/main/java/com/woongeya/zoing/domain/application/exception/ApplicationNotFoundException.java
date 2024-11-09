package com.woongeya.zoing.domain.application.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class ApplicationNotFoundException extends JJoingException {

    public ApplicationNotFoundException (Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 신청을 찾을 수 없습니다.", id));
    }
}
