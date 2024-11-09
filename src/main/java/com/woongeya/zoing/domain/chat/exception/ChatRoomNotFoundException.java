package com.woongeya.zoing.domain.chat.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.exception.JJoingException;

public class ChatRoomNotFoundException extends JJoingException {

	public ChatRoomNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 채팅방을 찾을 수 없습니다.", id));
	}
}
