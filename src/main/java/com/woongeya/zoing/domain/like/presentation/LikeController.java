package com.woongeya.zoing.domain.like.presentation;

import com.woongeya.zoing.domain.like.presentation.dto.response.LikerResponseDto;
import com.woongeya.zoing.domain.like.service.*;
import com.woongeya.zoing.domain.project.presetation.dto.response.ProjectResponseDto;
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
    private final CountLikedService countLikedService;

    @PostMapping("/{id}")
    public void createLike(@PathVariable Long id) {
        createLikeService.execute(id);
    }

    @DeleteMapping("/{id}")
    public void unLike(@PathVariable Long id) {
        deleteLikeService.execute(id);
    }

    @GetMapping("/{id}/liker")
    public ResponseEntity<List<LikerResponseDto>> findLiker (@PathVariable Long id) {
        return ResponseEntity.ok(findLikerService.execute(id));
    }

    @GetMapping("/{id}/liked")
    public ResponseEntity<List<ProjectResponseDto>> findLikedProject(@PathVariable Long id) {
        return ResponseEntity.ok(findLikedService.execute(id));
    }

    @GetMapping("/{id}/liker/count")
    public Long countLiker(@PathVariable Long id) { return countLikerService.execute(id); }

    @GetMapping("/{id}/liked/count")
    public Long countLiked(@PathVariable Long id) { return countLikedService.execute(id); }
}
