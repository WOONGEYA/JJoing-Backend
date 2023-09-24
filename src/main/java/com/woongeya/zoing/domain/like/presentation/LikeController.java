package com.woongeya.zoing.domain.like.presentation;

import com.woongeya.zoing.domain.like.presentation.dto.response.LikerResponseDto;
import com.woongeya.zoing.domain.like.service.*;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final CreateLikeService createLikeService;
    private final DeleteLikeService deleteLikeService;
    private final FindLikerService findLikerService;
    private final FindLikedService findLikedService;
    private final CountLikerService countLikerService;
    private final CheckLikeService checkLikeService;

    @PostMapping("/{id}")
    @Operation(summary = "좋아요 생성")
    public void createLike(@PathVariable Long id) {
        createLikeService.execute(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "좋아요 삭제")
    public void unLike(@PathVariable Long id) {
        deleteLikeService.execute(id);
    }

    @GetMapping("/{id}/liker")
    @Operation(summary = "좋아요 누른 사람 조회")
    public ResponseEntity<List<LikerResponseDto>> findLiker(@PathVariable Long id) {
        return ResponseEntity.ok(findLikerService.execute(id));
    }

    @GetMapping("/my")
    @Operation(summary = "내가 좋아요 누른 프로젝트 조회")
    public ResponseEntity<List<ProjectResponseDto>> findLikedProject() {
        return ResponseEntity.ok(findLikedService.execute());
    }

    @GetMapping("/{id}/liker/count")
    @Operation(summary = "프로젝트의 좋아요 갯수 조회")
    public Integer countLiker(@PathVariable Long id) {
        return countLikerService.execute(id);
    }

    @GetMapping("/check/{id}/project")
    @Operation(summary = "프로젝트 좋아요 여부 조회")
    public boolean checkLike(@PathVariable Long id) {
        return checkLikeService.execute(id);
    }
}
