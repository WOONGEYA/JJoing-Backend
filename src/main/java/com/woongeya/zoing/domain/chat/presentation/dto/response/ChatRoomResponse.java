package com.woongeya.zoing.domain.chat.presentation.dto.response;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;

public record ChatRoomResponse(
	String name,
	String imageUrl
) {

	public static ChatRoomResponse from(ChatRoom chatRoom) {
		return new ChatRoomResponse(chatRoom.getName(), chatRoom.getImageUrl());
	}
}
