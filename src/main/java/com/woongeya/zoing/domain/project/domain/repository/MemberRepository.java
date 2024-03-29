package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.type.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {

    List<Member> findByProjectId(Long id);
    List<Member> findByUserId(Long id);

    Member findByProjectIdAndRole(Long id, Role role);
    void deleteByProjectId(Long id);
}
