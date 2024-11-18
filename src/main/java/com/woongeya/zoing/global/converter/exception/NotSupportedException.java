package com.woongeya.zoing.global.converter.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class NotSupportedException extends JJoingException {

	public NotSupportedException() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, "지원하지 않는 형식입니다.");
	}
}
