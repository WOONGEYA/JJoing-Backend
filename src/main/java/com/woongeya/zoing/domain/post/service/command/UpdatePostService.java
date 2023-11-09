package com.woongeya.zoing.domain.post.service.command;

import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.exception.PostNotFoundException;
import com.woongeya.zoing.domain.post.presetation.dto.request.CreatePostRequest;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdatePostService {

    private final  UserFacade userFacade;
    private final PostRepository postRepository;

    public void execute(Long id, CreatePostRequest request) {
        User user = userFacade.getCurrentUser();
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if(post.isWriter(user)) {
            throw new IsNotWriterException();
        }
        post.update(request);
    }
}
