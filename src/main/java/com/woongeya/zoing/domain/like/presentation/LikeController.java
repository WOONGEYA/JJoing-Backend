package com.woongeya.zoing.domain.like.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.like.presentation.dto.response.LikerResponse;
import com.woongeya.zoing.domain.like.service.CheckLikeService;
import com.woongeya.zoing.domain.like.service.CountLikerService;
import com.woongeya.zoing.domain.like.service.CreateLikeService;
import com.woongeya.zoing.domain.like.service.DeleteLikeService;
import com.woongeya.zoing.domain.like.service.FindLikedService;
import com.woongeya.zoing.domain.like.service.FindLikerService;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponse;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

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
    public List<LikerResponse> findLiker(@PathVariable Long id) {
        return findLikerService.execute(id);
    }

    @GetMapping("/my")
    @Operation(summary = "내가 좋아요 누른 프로젝트 조회")
    public List<ProjectResponse> findLikedProject() {
        return findLikedService.execute();
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
