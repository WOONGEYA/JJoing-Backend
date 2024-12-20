package com.woongeya.zoing.domain.comment.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.comment.domain.Comment;
import com.woongeya.zoing.domain.comment.domain.repository.CommentRepository;
import com.woongeya.zoing.domain.comment.exception.CommentNotFoundException;
import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.exception.PostNotFoundException;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final AuthRepository authRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));

        if(!comment.isWriter(user.getId())) {
            throw new IsNotWriterException();
        }

        Post post = postRepository.findById(comment.getPostId())
                .orElseThrow(() -> new PostNotFoundException(comment.getPostId()));
        commentRepository.delete(comment);
        post.decreaseCommentCount();
    }
}
