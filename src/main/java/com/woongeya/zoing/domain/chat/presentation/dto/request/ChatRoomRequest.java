package com.woongeya.zoing.domain.chat.presentation.dto.request;

public record ChatRoomRequest(
	String name
) {

	public ChatRoomRequest(String name) {
		this.name = name;
	}
}
