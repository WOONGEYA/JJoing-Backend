package com.woongeya.zoing.domain.chat.domain.repository;

import java.util.List;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;

public interface CustomChatRoomRepository {

	public List<ChatRoom> findMyChatRoom(Long userId);
}
