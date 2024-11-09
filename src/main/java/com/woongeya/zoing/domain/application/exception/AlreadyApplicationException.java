package com.woongeya.zoing.domain.application.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class AlreadyApplicationException extends JJoingException {

    public AlreadyApplicationException(Long projectId) {
        super(HttpStatus.BAD_REQUEST, String.format("%s는 이미 신청한 프로젝트입니다.", projectId));
    }
}
