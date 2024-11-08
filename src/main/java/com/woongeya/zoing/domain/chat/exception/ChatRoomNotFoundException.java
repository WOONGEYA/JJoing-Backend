package com.woongeya.zoing.domain.chat.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class ChatRoomNotFoundException extends JJoingException {

	public ChatRoomNotFoundException() {
		super(ErrorCode.CHAT_ROOM_NOT_FOUND);
	}
}
