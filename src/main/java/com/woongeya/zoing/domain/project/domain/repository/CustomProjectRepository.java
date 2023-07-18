package com.woongeya.zoing.domain.project.domain.repository;

import com.woongeya.zoing.domain.project.domain.Project;

import java.util.List;

public interface CustomProjectRepository {

    List<Project> searchProject(String q);
}
