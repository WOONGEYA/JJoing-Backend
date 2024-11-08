package com.woongeya.zoing.domain.comment.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.exception.PostNotFoundException;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final AuthRepository authRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public void execute(Long postId, CreateCommentRequest request) {
        User user = authRepository.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        commentRepository.save(request.toEntity(postId, user));
        post.increaseCommentCount();
    }
}
