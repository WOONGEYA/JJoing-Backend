package com.woongeya.zoing.domain.comment.domain.repository;

import com.woongeya.zoing.domain.comment.domain.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {
}
