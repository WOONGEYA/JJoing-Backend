package com.woongeya.zoing.domain.post.presetation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.auth.annotation.LoginRequired;
import com.woongeya.zoing.domain.auth.service.implementation.AuthReader;
import com.woongeya.zoing.domain.post.presetation.dto.request.CreatePostRequest;
import com.woongeya.zoing.domain.post.presetation.dto.response.PostResponse;
import com.woongeya.zoing.domain.post.presetation.dto.response.PostResponseList;
import com.woongeya.zoing.domain.post.service.command.CreatePostService;
import com.woongeya.zoing.domain.post.service.command.DeletePostService;
import com.woongeya.zoing.domain.post.service.command.UpdatePostService;
import com.woongeya.zoing.domain.post.service.qeury.QueryPostOneService;
import com.woongeya.zoing.domain.post.service.qeury.QueryPostService;
import com.woongeya.zoing.domain.post.service.qeury.QuerySearchPostService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CreatePostService createPostService;
    private final QueryPostService queryPostService;
    private final QueryPostOneService queryPostOneService;
    private final QuerySearchPostService querySearchPostService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;
    private final AuthReader authReader;

    @PostMapping()
    @LoginRequired
    @Operation(summary = "게시글 생성")
    public void create(@RequestBody CreatePostRequest request) {
        createPostService.execute(authReader.getCurrentUser(), request);
    }

    @GetMapping
    @Operation(summary = "게시글 전체 조회")
    public PostResponseList getAll() {
        return queryPostService.execute();
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세 조회")
    public PostResponse getOne(@PathVariable Long id) {
        return queryPostOneService.execute(id);
    }

    @GetMapping("/search")
    @Operation(summary = "게시글 검색")
    public PostResponseList search(@RequestParam(name = "q") String q) {
        return querySearchPostService.execute(q);
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정")
    public void update(@PathVariable Long id, @RequestBody CreatePostRequest request) {
        updatePostService.execute(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제")
    public void delete(@PathVariable Long id) {
        deletePostService.execute(id);
    }
}
