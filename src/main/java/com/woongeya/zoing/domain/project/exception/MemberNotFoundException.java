package com.woongeya.zoing.domain.project.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class MemberNotFoundException extends JJoingException {

    public MemberNotFoundException() {
        super(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다");
    }
}
