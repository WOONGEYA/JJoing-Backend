package com.woongeya.zoing.domain.comment.service.command;

import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    public void execute(Long postId, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        commentRepository.save(new Comment(request.getContent(), postId, user.getId()));
    }
}
