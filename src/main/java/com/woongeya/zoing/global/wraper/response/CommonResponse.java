package com.woongeya.zoing.global.wraper.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public record CommonResponse<T> (
	HttpStatus state,
	T body,
	LocalDateTime timeStamp,
	String message
) {

	public static <T> CommonResponse<T> error(HttpStatus state, String message) {
		return new CommonResponse<>(state, null, LocalDateTime.now(), message);
	}

	public static <T> CommonResponse<T> success(HttpStatus state, T body) {
		return new CommonResponse<>(state, body, LocalDateTime.now(), "");
	}
}
