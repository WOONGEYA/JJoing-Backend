package com.woongeya.zoing.domain.project.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.request.CreateProjectRequest;
import com.woongeya.zoing.domain.project.presetation.dto.response.ImageResponse;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectInfoResponse;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponse;
import com.woongeya.zoing.domain.project.service.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final FindAlwaysNewProjectService findAlwaysNewProjectService;
    private final FindViewCountProjectService findViewCountProjectService;
    private final FindAlwaysViewCountProjectService findAlwaysViewCountProjectService;
    private final FindAlwaysLikeProjectService findAlwaysLikeProjectService;
    private final FindLikeProjectService findLikeProjectService;
    private final FindMyApplicationProjectService findMyApplicationProjectService;
    private final FindMyProjectService findMyProjectService;
    private final FindMyEndProjectService findMyEndProjectService;
    private final FindUserProjectService findUserProjectService;
    private final FindUserEndProjectService findUserEndProjectService;
    private final FindProjectInfoService findProjectInfoService;
    private final UploadImageService uploadImageService;
    private final SearchProjectService searchProjectService;
    private final UpdateProjectService updateProjectService;

    @PostMapping()
    @Operation(summary = "프로젝트 생성")
    public void createProject(@RequestBody CreateProjectRequest request) {
        createProjectService.execute(request);
    }

    @PostMapping("/image")
    @Operation(summary = "프로젝트 이미지 등록")
    public ImageResponse uploadImage(@RequestPart("image") MultipartFile image) {
        return uploadImageService.execute(image);
    }

    @PutMapping("/{id}")
    @Operation(summary = "프로젝트 수정")
    public void updateProject(@PathVariable Long id, @RequestBody CreateProjectRequest request) {
        updateProjectService.execute(id, request);
    }

    @PutMapping("/close/{id}")
    @Operation(summary = "프로젝트 모집 마감으로 변경")
    public void closeProject(@PathVariable Long id) {
        closeProjectService.execute(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "프로젝트 삭제")
    public void deleteProject(@PathVariable Long id) {
        deleteProjectService.execute(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "프로젝트 상세 조회")
    public ResponseEntity<ProjectInfoResponse> findProjectInfo(@PathVariable Long id) {
        return ResponseEntity.ok(findProjectInfoService.execute(id));
    }

    @GetMapping()
    @Operation(summary = "전체 프로젝트 조회(정렬 기능 있음)")
    public List<ProjectResponse> findProject(@RequestParam(name = "criteria", required = false, defaultValue = ("id")) String criteria,
                                                @RequestParam(name = "state", required = false, defaultValue = ("always")) String state) {
        if (state.equals("always")) {
            if (criteria.equals("view")) {
                return findAlwaysViewCountProjectService.execute();
            }
            if (criteria.equals("like")) {
                return findAlwaysLikeProjectService.execute();
            }
            return findAlwaysNewProjectService.execute();
        }

        if (criteria.equals("view")) {
            return findViewCountProjectService.execute(state);
        }
        if (criteria.equals("like")) {
            return findLikeProjectService.execute(state);
        }

        return findNewProjectService.execute(state);
    }

    @GetMapping("/search")
    @Operation(summary = "프로젝트 검색")
    public ResponseEntity<List<ProjectResponse>> searchProject(@RequestParam(name = "q") String q) {
        return ResponseEntity.ok(searchProjectService.execute(q));
    }

    @GetMapping("/application")
    @Operation(summary = "내가 신청한 프로젝트 조회")
    public ResponseEntity<List<ProjectResponse>> findMyApplicationProject() {
        return ResponseEntity.ok(findMyApplicationProjectService.execute());
    }

    @GetMapping("/my")
    @Operation(summary = "내가 참여중인 프로젝트 조회")
    public ResponseEntity<List<ProjectResponse>> findMyProject() {
        return ResponseEntity.ok(findMyProjectService.execute());
    }

    @GetMapping("/my/end")
    @Operation(summary = "내가 참여했던 프로젝트 조회")
    public ResponseEntity<List<ProjectResponse>> findMyEndProject() {
        return ResponseEntity.ok(findMyEndProjectService.execute());
    }

    @GetMapping("/{id}/user")
    @Operation(summary = "유저가 참여중인 프로젝트 조회")
    public ResponseEntity<List<ProjectResponse>> findUserProject(@PathVariable Long id) {
        return ResponseEntity.ok(findUserProjectService.execute(id));
    }

    @GetMapping("/{id}/user/end")
    @Operation(summary = "유저가 참여했던 프로젝트 조회")
    public ResponseEntity<List<ProjectResponse>> findUserEndProject(@PathVariable Long id) {
        return ResponseEntity.ok(findUserEndProjectService.execute(id));
    }
}
