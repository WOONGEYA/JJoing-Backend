package com.woongeya.zoing.domain.chat.service.command;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;
import com.woongeya.zoing.domain.chat.domain.repository.ChatRepository;
import com.woongeya.zoing.domain.chat.domain.repository.ChatRoomRepository;
import com.woongeya.zoing.domain.chat.presentation.dto.request.ChatRequest;
import com.woongeya.zoing.domain.user.UserFacade;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandChatService {

	private final ChatRepository chatRepository;
	private final ChatRoomRepository chatRoomRepository;
	private final UserFacade userFacade;

	public void create(Long roomId, ChatRequest request) {
		ChatRoom chatRoom = chatRoomRepository.getById(roomId);
		chatRepository.save(
			request.toEntity(userFacade.getCurrentUser(), chatRoom)
		);
	}
}
