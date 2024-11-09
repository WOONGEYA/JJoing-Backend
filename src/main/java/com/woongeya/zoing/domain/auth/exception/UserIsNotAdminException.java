package com.woongeya.zoing.domain.auth.exception;

import static org.springframework.http.HttpStatus.*;

import com.woongeya.zoing.global.exception.JJoingException;

public class UserIsNotAdminException extends JJoingException {
	public UserIsNotAdminException() {
		super(UNAUTHORIZED, "사용자가 어드민이 아닙니다.");
	}
}
