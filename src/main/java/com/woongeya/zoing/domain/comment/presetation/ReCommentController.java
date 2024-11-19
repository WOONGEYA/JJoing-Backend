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
import com.woongeya.zoing.domain.comment.presetation.dto.response.ReCommentResponse;
import com.woongeya.zoing.domain.comment.service.command.CreateReCommentService;
import com.woongeya.zoing.domain.comment.service.command.DeleteReCommentService;
import com.woongeya.zoing.domain.comment.service.command.UpdateReCommentService;
import com.woongeya.zoing.domain.comment.service.query.QueryReCommentListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recomment")
public class ReCommentController {

    private final CreateReCommentService createReCommentService;
    private final QueryReCommentListService queryReCommentListService;
    private final DeleteReCommentService deleteReCommentService;
    private final UpdateReCommentService updateReCommentService;

    @PostMapping("/{id}")
    public void create(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        createReCommentService.execute(id, request);
    }

    @GetMapping("/{id}")
    public List<ReCommentResponse> findAll(@PathVariable Long id) {
        return queryReCommentListService.execute(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteReCommentService.execute(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateCommentRequest request) {
        updateReCommentService.execute(id, request);
    }
}
