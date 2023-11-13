package com.woongeya.zoing.domain.comment.domain.repository;

import com.woongeya.zoing.domain.comment.domain.ReComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCommentRepository extends JpaRepository<ReComment, Long> {
}
