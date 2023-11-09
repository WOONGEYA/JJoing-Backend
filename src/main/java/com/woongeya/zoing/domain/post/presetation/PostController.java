package com.woongeya.zoing.domain.post.presetation;

import com.woongeya.zoing.domain.post.presetation.dto.request.CreatePostRequest;
import com.woongeya.zoing.domain.post.service.command.CreatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CreatePostService createPostService;

    @PostMapping()
    public ResponseEntity<Void> create(CreatePostRequest request) {
        createPostService.execute(request);
        return ResponseEntity.noContent().build();
    }
}
