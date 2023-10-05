package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CloseEndProjectService {

    private final ProjectRepository projectRepository;

    public void execute() {
        System.out.println(LocalDate.now());
        List<Project> projects = projectRepository.findByEndDate(LocalDate.now());
        projectRepository.deleteAll(projects);
    }
}
