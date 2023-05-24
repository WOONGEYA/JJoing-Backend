package com.woongeya.zoing.domain.project.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.project.service.ProjectCloseService;
import com.woongeya.zoing.domain.project.service.ProjectCreateService;
import com.woongeya.zoing.domain.project.service.ProjectDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectCreateService projectCreateService;
    private final ProjectCloseService projectCloseService;
    private final ProjectDeleteService projectDeleteService;

    @PostMapping("")
    public void createProject(@RequestBody CreateProjectRequestDto request) {
        projectCreateService.execute(request);
    }

    @PutMapping("/close/{id}")
    @PreAuthorize("hasRole('PROJECT_ADMIN')")
    public void closeProject(@PathVariable Long id) {
        projectCloseService.execute(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('PROJECT_ADMIN')")
    public void deleteProject(@PathVariable Long id) {
        projectDeleteService.execute(id);
    }
}
