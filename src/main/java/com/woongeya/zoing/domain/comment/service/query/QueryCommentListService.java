package com.woongeya.zoing.domain.comment.service.query;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.presetation.dto.response.CommentResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCommentListService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    public List<CommentResponse> execute(Long id) {
        List<Comment> comments = commentRepository.findByPostId(id);

        return comments.stream()
                .map(comment -> CommentResponse.of(comment, userFacade.getUserById(comment.getUserId())))
                .collect(Collectors.toList());
    }
}
