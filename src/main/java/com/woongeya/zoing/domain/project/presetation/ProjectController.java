package com.woongeya.zoing.domain.project.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequestDto;
import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponseDto;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import com.woongeya.zoing.domain.project.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final CloseProjectService closeProjectService;
    private final DeleteProjectService deleteProjectService;
    private final FindNewProjectService findNewProjectService;
    private final FindViewCountProjectService findViewCountProjectService;
    private final FindMyApplicationProjectService findMyApplicationProjectService;
    private final FindProjectInfoService findProjectInfoService;
    private final UploadImageService uploadImageService;
    private final SearchProjectService searchProjectService;

    @PostMapping("")
    public void createProject(@RequestBody CreateProjectRequestDto request) {
        createProjectService.execute(request);
    }

    @PostMapping("/image")
    public List<ImageResponseDto> uploadImage(@RequestPart("image")List<MultipartFile> images) {
        return uploadImageService.execute(images);
    }

    @PutMapping("/close/{id}")
    public void closeProject(@PathVariable Long id) {
        closeProjectService.execute(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        deleteProjectService.execute(id);
    }

    @GetMapping("{id}")
    public ProjectResponseDto findProjectInfo(@PathVariable Long id) {
        return findProjectInfoService.execute(id);
    }

    @GetMapping("")
    public List<ProjectResponseDto> findProject(@RequestParam(name = "criteria", required = false, defaultValue = ("id")) String criteria,
                                                @RequestParam(name = "state", required = false, defaultValue = ("always")) String state) {
        if (criteria.equals("view")) {
            return findViewCountProjectService.execute(state);
        }

        return findNewProjectService.execute(state);
    }

    @GetMapping("/search")
    public List<ProjectResponseDto> searchProject(@RequestParam(name = "q") String q) {
        return searchProjectService.execute(q);
    }

    @GetMapping("/application")
    public List<ProjectResponseDto> findMyApplicationProject() {
        return findMyApplicationProjectService.execute();
    }
}
