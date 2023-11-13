package com.woongeya.zoing.domain.comment.presetation;

import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.comment.presetation.dto.response.CommentResponse;
import com.woongeya.zoing.domain.comment.service.command.CreateCommentService;
import com.woongeya.zoing.domain.comment.service.query.QueryCommentListService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final QueryCommentListService queryCommentListService;

    @PostMapping("/{id}")
    @Operation(summary = "댓글 생성")
    public ResponseEntity<Void> create(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        createCommentService.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "댓글 조회")
    public ResponseEntity<List<CommentResponse>> getAll(@PathVariable Long id) {
        return ResponseEntity.ok(queryCommentListService.execute(id));
    }
}
