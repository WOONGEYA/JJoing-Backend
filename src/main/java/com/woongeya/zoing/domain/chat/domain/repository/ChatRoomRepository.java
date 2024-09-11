package com.woongeya.zoing.domain.chat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
