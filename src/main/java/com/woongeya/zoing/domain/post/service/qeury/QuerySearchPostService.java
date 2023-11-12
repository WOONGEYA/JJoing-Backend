package com.woongeya.zoing.domain.post.service.qeury;

import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.repository.PostRepository;
import com.woongeya.zoing.domain.post.presetation.dto.response.PostResponse;
import com.woongeya.zoing.domain.post.presetation.dto.response.PostResponseList;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class QuerySearchPostService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;

    public PostResponseList execute(String q) {
        List<Post> posts = postRepository.searchPost(q);

        return PostResponseList.of(
                posts.stream()
                        .map(post -> PostResponse.of(post, userFacade.getUserById(post.getWriter())))
                        .collect(Collectors.toList())
        );
    }
}
