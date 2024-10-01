package com.woongeya.zoing.domain.chat.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.chat.presentation.dto.request.ChatRoomRequest;
import com.woongeya.zoing.domain.chat.presentation.dto.response.ChatRoomResponse;
import com.woongeya.zoing.domain.chat.service.command.CommandChatRoomService;
import com.woongeya.zoing.domain.chat.service.query.QueryChatRoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chatroom")
@RequiredArgsConstructor
public class ChatRoomController {

	private final CommandChatRoomService commandChatRoomService;
	private final QueryChatRoomService queryChatRoomService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ChatRoomRequest request) {
		commandChatRoomService.create(request);
	}

	@GetMapping("/my")
	public List<ChatRoomResponse> findMyChatRoom() {
		return queryChatRoomService.findMyChatRoom();
	}
}
