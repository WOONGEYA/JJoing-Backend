package com.woongeya.zoing.domain.auth.exception;

import static org.springframework.http.HttpStatus.*;

import com.woongeya.zoing.global.exception.JJoingException;

public class TokenNotExistException extends JJoingException {
	public TokenNotExistException() {
		super(FORBIDDEN, "토큰이 넘어오지 않았습니다.");
	}
}
