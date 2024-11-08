package com.woongeya.zoing.domain.auth.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.error.JJoingException;

public class TokenMissingException extends JJoingException {
	public TokenMissingException() {
		super(HttpStatus.UNAUTHORIZED, "토큰이 없습니다.");
	}
}
