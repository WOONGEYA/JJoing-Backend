package com.woongeya.zoing.domain.chat.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.chat.presentation.dto.request.ChatRoomRequest;
import com.woongeya.zoing.domain.chat.service.command.CommandChatRoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chatroom")
@RequiredArgsConstructor
public class ChatRoomController {

	private final CommandChatRoomService commandChatRoomService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ChatRoomRequest request) {
		commandChatRoomService.create(request);
	}
}
