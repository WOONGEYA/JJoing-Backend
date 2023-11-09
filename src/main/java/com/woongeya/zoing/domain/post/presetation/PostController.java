package com.woongeya.zoing.domain.post.presetation;

import com.woongeya.zoing.domain.post.presetation.dto.request.CreatePostRequest;
import com.woongeya.zoing.domain.post.presetation.dto.response.PostResponseList;
import com.woongeya.zoing.domain.post.service.command.CreatePostService;
import com.woongeya.zoing.domain.post.service.qeury.QueryPostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CreatePostService createPostService;
    private final QueryPostService queryPostService;

    @PostMapping()
    @Operation(summary = "게시글 생성")
    public ResponseEntity<Void> create(CreatePostRequest request) {
        createPostService.execute(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @Operation(summary = "게시글 전체 조회")
    public ResponseEntity<PostResponseList> getAll() {
        return ResponseEntity.ok(queryPostService.execute());
    }
}
