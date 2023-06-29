package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByProjectId(Long id);
    List<Member> findByUserId(Long id);
}
