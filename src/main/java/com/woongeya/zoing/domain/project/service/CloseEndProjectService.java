package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CloseEndProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public void execute() {
        List<Project> projects = projectRepository.findByEndDate(LocalDate.now());

        projects.forEach(Project::close);
    }
}
