package com.woongeya.zoing.domain.comment.presetation;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.comment.presetation.dto.response.CommentResponse;
import com.woongeya.zoing.domain.comment.service.command.CreateCommentService;
import com.woongeya.zoing.domain.comment.service.command.DeleteCommentService;
import com.woongeya.zoing.domain.comment.service.command.UpdateCommentService;
import com.woongeya.zoing.domain.comment.service.query.QueryCommentListService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final QueryCommentListService queryCommentListService;
    private final UpdateCommentService updateCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping("/{id}")
    @Operation(summary = "댓글 생성")
    public void create(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        createCommentService.execute(id, request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "댓글 조회")
    public List<CommentResponse> getAll(@PathVariable Long id) {
        return queryCommentListService.execute(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "댓글 수정")
    public void update(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        updateCommentService.execute(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "댓글 삭제")
    public void delete(@PathVariable Long id) {
        deleteCommentService.execute(id);
    }
}
