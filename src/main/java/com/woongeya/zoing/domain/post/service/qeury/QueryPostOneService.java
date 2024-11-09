package com.woongeya.zoing.domain.post.service.qeury;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.exception.PostNotFoundException;
import com.woongeya.zoing.domain.post.presetation.dto.response.PostResponse;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryPostOneService {

    private final AuthRepository authRepository;
    private final UserFacade userFacade;
    private final PostRepository postRepository;

    public PostResponse execute(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        User writer = userFacade.getUserById(post.getWriter());
        post.increaseViewCnt();

        return PostResponse.of(post, writer);
    }
}
