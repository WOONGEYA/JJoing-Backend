package com.woongeya.zoing.domain.follow.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class AlreadyFollowException extends JJoingException {

    public AlreadyFollowException(Long id) {
        super(HttpStatus.BAD_REQUEST, String.format("%s는 이미 팔로우된 상태입니다.", id));
    }
}
