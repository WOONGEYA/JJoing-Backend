package com.woongeya.zoing.domain.chat.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woongeya.zoing.domain.chat.domain.ChatRoom;
import com.woongeya.zoing.domain.chat.domain.repository.ChatRoomRepository;
import com.woongeya.zoing.domain.chat.presentation.dto.response.ChatRoomResponse;
import com.woongeya.zoing.domain.user.UserFacade;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QueryChatRoomService {

	private final ChatRoomRepository chatRoomRepository;
	private final UserFacade userFacade;

	public List<ChatRoomResponse> findMyChatRoom() {
		return chatRoomRepository.findMyChatRoom(userFacade.getCurrentUser().getId()).stream()
			.map(ChatRoomResponse::from).toList();
	}
}
