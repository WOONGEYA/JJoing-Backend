package com.woongeya.zoing.domain.project.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.QProject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.woongeya.zoing.domain.project.domain.QProject.*;

@Repository
@RequiredArgsConstructor
public class CustomProjectRepositoryImpl implements CustomProjectRepository {

    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Project> searchProject(String q) {
        return jpaQueryFactory
                .selectFrom(project)
                .where(project.name.contains(q)
                        .or(project.content.contains(q))
                )
                .fetch();
    }
}
