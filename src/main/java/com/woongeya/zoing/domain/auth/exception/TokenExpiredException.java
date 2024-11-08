package com.woongeya.zoing.domain.auth.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.error.JJoingException;

public class TokenExpiredException extends JJoingException {
	public TokenExpiredException() {
		super(HttpStatus.FORBIDDEN, "토큰이 만료되었습니다.");
	}
}
