package com.woongeya.zoing.domain.follow.domain.repository;

import com.woongeya.zoing.domain.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
