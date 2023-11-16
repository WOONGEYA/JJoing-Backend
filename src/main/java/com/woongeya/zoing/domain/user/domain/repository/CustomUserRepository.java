package com.woongeya.zoing.domain.user.domain.repository;

import com.woongeya.zoing.domain.user.domain.User;

import java.util.List;

public interface CustomUserRepository {

    List<User> searchUser(String q);
}
