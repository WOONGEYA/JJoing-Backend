package com.woongeya.zoing.domain.chat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woongeya.zoing.domain.chat.domain.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
