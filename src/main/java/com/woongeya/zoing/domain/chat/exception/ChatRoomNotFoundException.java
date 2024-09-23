package com.woongeya.zoing.domain.chat.exception;

import org.springframework.http.HttpStatus;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;

public class ChatRoomNotFoundException extends ZoingException {

	public ChatRoomNotFoundException() {
		super(ErrorCode.CHAT_ROOM_NOT_FOUND);
	}
}
