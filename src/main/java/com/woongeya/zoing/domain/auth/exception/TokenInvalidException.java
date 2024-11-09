package com.woongeya.zoing.domain.auth.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class TokenInvalidException extends JJoingException {
	public TokenInvalidException() {
		super(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다.");
	}
}
