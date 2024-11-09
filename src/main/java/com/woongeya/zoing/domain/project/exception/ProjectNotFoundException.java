package com.woongeya.zoing.domain.project.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class ProjectNotFoundException extends JJoingException {

    public ProjectNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 프로젝트를 찾을 수 없습니다.", id));
    }
}
