package com.woongeya.zoing.domain.post.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class PostNotFoundException extends JJoingException {

    public PostNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 게시글을 찾을 수 없습니다.", id));
    }
}