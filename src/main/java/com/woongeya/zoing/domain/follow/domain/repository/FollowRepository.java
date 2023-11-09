package com.woongeya.zoing.domain.follow.domain.repository;

import com.woongeya.zoing.domain.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    Optional<Follow> findByFromUserIdAndToUserId(Long fromUserId, Long toUserId);
    List<Follow> findByFromUserId(Long id);
    List<Follow> findByToUserId(Long id);
    Integer countByToUserId(Long id);
    Integer countByFromUserId(Long id);
    boolean existsByToUserIdAndFromUserId(Long toUserId, Long fromUserId);

}
