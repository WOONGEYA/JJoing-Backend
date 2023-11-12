package com.woongeya.zoing.domain.post.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woongeya.zoing.domain.post.domain.Post;
import com.woongeya.zoing.domain.post.domain.QPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.woongeya.zoing.domain.post.domain.QPost.post;

@Repository
@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> searchPost(String q) {
        return jpaQueryFactory
                .selectFrom(post)
                .where(post.title.contains(q)
                        .or(post.content.contains(q))
                )
                .fetch();
    }
}
