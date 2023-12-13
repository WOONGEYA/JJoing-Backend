package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;

import java.util.List;

public interface CustomProjectRepository {

    List<Project> searchProject(String q);

    List<Project> findProject(Long id);

    List<Project> findProjectLikeDesc();

    List<Project> findProjectByStateLikeDesc(ProjectState state);

    List<Project> findMyApplicationProject(Long userId);
}
