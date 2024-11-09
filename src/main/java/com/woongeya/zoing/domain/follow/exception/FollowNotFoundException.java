package com.woongeya.zoing.domain.follow.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class FollowNotFoundException extends JJoingException {

    public FollowNotFoundException () {
        super(HttpStatus.NOT_FOUND, "팔로우를 찾을 수 없습니다.");
    }
}
