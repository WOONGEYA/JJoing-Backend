package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectDeleteService {

    private final ProjectRepository projectRepository;

    @Transactional
    public void execute(Long id) {
        projectRepository.deleteById(id);
    }
}
