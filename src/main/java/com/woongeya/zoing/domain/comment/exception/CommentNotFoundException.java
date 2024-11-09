package com.woongeya.zoing.domain.comment.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class CommentNotFoundException extends JJoingException {

    public CommentNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 댓글을 찾을 수 없습니다", id));
    }
}
