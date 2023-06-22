package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Member;

import java.util.Optional;

public interface CustomMemberRepository {

    Optional<Member> findByUserIdAndProjectId(Long userId, Long projectId);
}
