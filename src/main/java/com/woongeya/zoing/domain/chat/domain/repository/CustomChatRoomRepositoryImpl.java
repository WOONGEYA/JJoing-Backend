package com.woongeya.zoing.domain.chat.domain.repository;

import static com.woongeya.zoing.domain.chat.domain.QChat.*;
import static com.woongeya.zoing.domain.chat.domain.QChatRoom.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woongeya.zoing.domain.chat.domain.ChatRoom;
import com.woongeya.zoing.domain.chat.domain.QChat;
import com.woongeya.zoing.domain.chat.domain.QChatRoom;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomChatRoomRepositoryImpl implements CustomChatRoomRepository {

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<ChatRoom> findMyChatRoom(Long userId) {
		return jpaQueryFactory.selectFrom(chatRoom)
			.join(chat).on(chat.chatRoom.eq(chatRoom))
			.where(chat.senderId.eq(userId))
			.fetch();
	}
}
