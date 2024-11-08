package com.woongeya.zoing.domain.post.service.command;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.presetation.dto.request.CreatePostRequest;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePostService {

    private final AuthRepository authRepository;
    private final PostRepository postRepository;

    public void execute(CreatePostRequest request) {
        User user = authRepository.getCurrentUser();
        postRepository.save(request.toEntity(user));
    }
}
