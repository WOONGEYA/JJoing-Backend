package com.woongeya.zoing.domain.post.domain.repository;

import com.woongeya.zoing.domain.post.domain.Post;

import java.util.List;

public interface CustomPostRepository {

    List<Post> searchPost(String q);
}
