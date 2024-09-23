package com.woongeya.zoing.domain.chat.presentation.dto.request;

import com.woongeya.zoing.domain.chat.domain.Chat;
import com.woongeya.zoing.domain.chat.domain.ChatRoom;
import com.woongeya.zoing.domain.user.domain.User;

public record ChatRequest (
	String message
) {

	public Chat toEntity(User sender, ChatRoom room) {
		return new Chat(message, sender.getId(), sender.getName(), room);
	}
}
