package com.woongeya.zoing.domain.chat.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chat_id")
	private Long id;

	private String message;

	private LocalDateTime createdAt;

	private Long senderId;

	private String senderName;

	public Chat(String message, Long senderId, String senderName) {
		this.message = message;
		this.createdAt = LocalDateTime.now();
		this.senderId = senderId;
		this.senderName = senderName;
	}
}
