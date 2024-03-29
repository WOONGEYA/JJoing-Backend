package com.woongeya.zoing.domain.post.presetation;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    @Operation(summary = "게시글 생성")
    public ResponseEntity<Void> create(@RequestBody CreatePostRequest request) {
        createPostService.execute(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    @Operation(summary = "게시글 전체 조회")
    public ResponseEntity<PostResponseList> getAll() {
        return ResponseEntity.ok(queryPostService.execute());
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세 조회")
    public ResponseEntity<PostResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(queryPostOneService.execute(id));
    }

    @GetMapping("/search")
    @Operation(summary = "게시글 검색")
    public ResponseEntity<PostResponseList> search(@RequestParam(name = "q") String q) {
        return ResponseEntity.ok(querySearchPostService.execute(q));
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CreatePostRequest request) {
        updatePostService.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePostService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
