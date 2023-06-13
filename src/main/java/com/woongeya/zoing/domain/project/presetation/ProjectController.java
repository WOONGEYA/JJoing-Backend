package com.woongeya.zoing.domain.project.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import com.woongeya.zoing.domain.project.service.CloseProjectService;
import com.woongeya.zoing.domain.project.service.CreateProjectService;
import com.woongeya.zoing.domain.project.service.DeleteProjectService;
import com.woongeya.zoing.domain.project.service.FindProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final CloseProjectService closeProjectService;
    private final DeleteProjectService deleteProjectService;
    private final FindProjectService findProjectService;

    @PostMapping("")
    public void createProject(@RequestBody CreateProjectRequestDto request) {
        createProjectService.execute(request);
    }

    @PutMapping("/close/{id}")
    public void closeProject(@PathVariable Long id) {
        closeProjectService.execute(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        deleteProjectService.execute(id);
    }

    @GetMapping("")
    public List<ProjectResponseDto> findProject() {
        return findProjectService.execute();
    }
}
