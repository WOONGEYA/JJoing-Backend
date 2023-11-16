package com.woongeya.zoing.domain.user.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.woongeya.zoing.domain.user.domain.QUser.user;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> searchUser(String q) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.name.contains(q)
                        .or(user.nickName.contains(q))
                )
                .fetch();
    }
}
