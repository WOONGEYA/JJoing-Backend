package com.woongeya.zoing.domain.chat.service.command;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;
import com.woongeya.zoing.domain.chat.domain.repository.ChatRoomRepository;
import com.woongeya.zoing.domain.chat.presentation.dto.request.ChatRoomRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandChatRoomService {

	private final ChatRoomRepository chatRoomRepository;

	public void create(ChatRoomRequest request) {
		chatRoomRepository.save(new ChatRoom(request.name()));
	}
}
