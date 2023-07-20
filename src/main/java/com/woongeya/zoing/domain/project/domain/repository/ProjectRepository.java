package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.type.ProjectState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>, CustomProjectRepository {

    List<Project> findAllByStateOrderByIdDesc(ProjectState state);
    List<Project> findAllByStateOrderByViewCountDesc(ProjectState state);
    List<Project> findAllByOrderByIdDesc();
    List<Project> findAllByOrderByViewCountDesc();

}
