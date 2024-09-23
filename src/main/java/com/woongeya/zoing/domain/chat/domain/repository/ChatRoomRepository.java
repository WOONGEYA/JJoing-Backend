package com.woongeya.zoing.domain.chat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;
import com.woongeya.zoing.domain.chat.exception.ChatRoomNotFoundException;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

	default public ChatRoom getById(Long chatRoomId) {
		return findById(chatRoomId).orElseThrow(ChatRoomNotFoundException::new);
	}
}
