package com.woongeya.zoing.domain.project.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.woongeya.zoing.domain.application.domain.QApplication.application;
import static com.woongeya.zoing.domain.like.domain.QLike.like;
import static com.woongeya.zoing.domain.project.domain.QMember.*;
import static com.woongeya.zoing.domain.project.domain.QProject.project;

@Repository
@RequiredArgsConstructor
public class CustomProjectRepositoryImpl implements CustomProjectRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Project> searchProject(String q) {
        return jpaQueryFactory
                .selectFrom(project)
                .where(project.name.contains(q)
                        .or(project.content.contains(q))
                )
                .fetch();
    }

    @Override
    public List<Project> findMyEndProject(Long userId) {
        return jpaQueryFactory
                .selectFrom(project)
                .join(member).on(member.project.eq(project))
                .where(member.userId.eq(userId).and(project.state.eq(ProjectState.FOUND)))
                .fetch();
    }

    @Override
    public List<Project> findMyProject(Long userId) {
        return jpaQueryFactory
                .selectFrom(project)
                .join(member).on(member.project.eq(project))
                .where(member.userId.eq(userId).and(project.state.eq(ProjectState.FINDING)))
                .fetch();
    }

    @Override
    public List<Project> findProjectLikeDesc() {
        return jpaQueryFactory
                .selectFrom(project)
                .leftJoin(like).on(project.id.eq(like.projectId))
                .groupBy(project)
                .orderBy(like.count().desc(), project.id.desc())
                .fetch();
    }

    @Override
    public List<Project> findProjectByStateLikeDesc(ProjectState state) {
        return jpaQueryFactory
                .selectFrom(project)
                .leftJoin(like).on(project.id.eq(like.projectId))
                .where(project.state.eq(state))
                .groupBy(project)
                .orderBy(like.count().desc(), project.id.desc())
                .fetch();
    }

    @Override
    public List<Project> findMyApplicationProject(Long userId) {
        return jpaQueryFactory
                .selectFrom(project)
                .join(application).on(project.id.eq(application.projectId))
                .where(application.userId.eq(userId))
                .orderBy(application.id.desc())
                .fetch();
    }
}
