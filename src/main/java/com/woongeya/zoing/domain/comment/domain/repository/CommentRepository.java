package com.woongeya.zoing.domain.comment.domain.repository;


import com.woongeya.zoing.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
