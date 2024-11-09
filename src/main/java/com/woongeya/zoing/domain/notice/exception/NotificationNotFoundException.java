package com.woongeya.zoing.domain.notice.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class NotificationNotFoundException extends JJoingException {

    public NotificationNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 알람을 찾을 수 없습니다.", id));
    }
}
