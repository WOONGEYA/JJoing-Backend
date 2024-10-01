package com.woongeya.zoing.domain.chat.presentation.dto.request;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;

public record ChatRoomRequest(
	String name,
	String imageUrl
) {

	public ChatRoom toEntity() {
		return new ChatRoom(name, imageUrl);
	}
}
