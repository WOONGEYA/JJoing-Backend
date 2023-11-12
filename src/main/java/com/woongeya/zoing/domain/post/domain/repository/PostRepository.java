package com.woongeya.zoing.domain.post.domain.repository;

import com.woongeya.zoing.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, CustomPostRepository {
}
