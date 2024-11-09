package com.woongeya.zoing.domain.user.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class UserNotFoundException extends JJoingException {

    public UserNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 찾을 수 없습니다.",  id));
    }
}
