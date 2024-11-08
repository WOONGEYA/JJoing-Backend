package com.woongeya.zoing.domain.auth.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.error.JJoingException;

public class UserNotLoginException extends JJoingException {
	public UserNotLoginException() {
		super(FORBIDDEN, "유저가 로그인하지 않았습니다.");
	}
}
