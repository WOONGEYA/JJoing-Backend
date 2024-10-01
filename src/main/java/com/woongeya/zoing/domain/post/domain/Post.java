package com.woongeya.zoing.domain.post.domain;

import com.woongeya.zoing.domain.post.presetation.dto.request.CreatePostRequest;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 1000)
    private String content;

    private Integer viewCount;

    private Integer commentCount;

    private String imgUrl;

    @CreatedDate
    private LocalDateTime createTime;

    private Long writer;

    @Builder
    public Post(String title, String content, Integer viewCount, String imgUrl, LocalDateTime createTime, Long writer) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.writer = writer;
        this.commentCount = 0;
    }

    @PrePersist
    public void createAt() {
        this.createTime = LocalDateTime.now();
    }

    public void update(CreatePostRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.imgUrl = request.imgUrl();
    }

    public Boolean isWriter(User user) {
        return Objects.equals(user.getId(), writer);
    }

    public void increaseViewCnt() {
        this.viewCount++;
    }

    public void increaseCommentCount() {
        this.commentCount++;
    }

    public void decreaseCommentCount() {
        this.commentCount--;
    }
}
