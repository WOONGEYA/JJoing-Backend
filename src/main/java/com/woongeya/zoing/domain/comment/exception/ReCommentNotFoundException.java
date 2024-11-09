package com.woongeya.zoing.domain.comment.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class ReCommentNotFoundException extends JJoingException {

    public ReCommentNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 대댓글을 찾을 수 없습니다", id));
    }
}

