package com.woongeya.zoing.domain.comment.domain.repository;

import com.woongeya.zoing.domain.comment.domain.ReComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReCommentRepository extends JpaRepository<ReComment, Long> {

    List<ReComment> findByCommentId(Long commentId);
}
