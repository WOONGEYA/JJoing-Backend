package com.woongeya.zoing.domain.project.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woongeya.zoing.domain.project.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.woongeya.zoing.domain.project.domain.QMember.member;
import static com.woongeya.zoing.domain.project.domain.QProject.project;

@RequiredArgsConstructor
@Repository
public class CustomMemberRepositoryImpl implements CustomMemberRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Member> findByUserIdAndProjectId(Long userId, Long projectId) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(member)
                        .from(member)
                        .innerJoin(project)
                        .on(member.project.id.eq(projectId))
                        .where(member.userId.eq(userId))
                        .distinct()
                        .fetchOne()
        );
    }
}
