package com.woongeya.zoing.domain.follow.domain.repository;

import com.woongeya.zoing.domain.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    List<Follow> findByFromUserId(Long id);
    List<Follow> findByToUserId(Long id);
}
