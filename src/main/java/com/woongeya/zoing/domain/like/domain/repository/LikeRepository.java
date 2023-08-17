package com.woongeya.zoing.domain.like.domain.repository;

import com.woongeya.zoing.domain.like.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndProjectId(Long userId, Long projectId);
    List<Like> findByProjectId(Long projectId);
    List<Like> findByUserId(Long userId);
    Long countByUserId(Long userId);
    Long countByProjectId(Long projectId);
}
