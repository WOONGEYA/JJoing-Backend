package com.woongeya.zoing.domain.chat.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.chat.presentation.dto.request.ChatRequest;
import com.woongeya.zoing.domain.chat.service.command.CommandChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ChatController {

	private final CommandChatService commandChatService;

	@MessageMapping("/{roomId}")
	@SendTo("/room/{roomId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void send(@DestinationVariable Long roomId, ChatRequest request) {
		commandChatService.create(roomId, request);
	}
}
