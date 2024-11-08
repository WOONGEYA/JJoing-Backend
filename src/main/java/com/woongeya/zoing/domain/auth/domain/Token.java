package com.woongeya.zoing.domain.auth.domain;


public record Token (
	String accessToken,
	String refreshToken
) {
}
