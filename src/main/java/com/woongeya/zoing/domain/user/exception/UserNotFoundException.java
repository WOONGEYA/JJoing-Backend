package com.woongeya.zoing.domain.user.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class UserNotFoundException extends JJoingException {

    public UserNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디 가진 사용자를 찾을 수 없습니다.", id));
    }

    public UserNotFoundException(String email) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 이메일을 가진 사용자를 찾을 수 없습니다.", email));
    }
}
