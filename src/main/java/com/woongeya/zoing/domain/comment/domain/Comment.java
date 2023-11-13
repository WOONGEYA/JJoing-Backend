package com.woongeya.zoing.domain.comment.domain;

import com.woongeya.zoing.domain.comment.presetation.dto.request.CreateCommentRequest;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commnet_id")
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createTime;

    private Integer reCommentCount;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

    @Builder
    public Comment(String content, Long postId, Long userId) {
        this.content = content;
        this.postId = postId;
        this.userId = userId;
        this.reCommentCount = 0;
    }

    @PrePersist
    public void createAt() {
        this.createTime = LocalDateTime.now();
    }

    public boolean isWriter(Long writerId) {
        return Objects.equals(this.userId, writerId);
    }

    public void update(CreateCommentRequest request) {
        this.content = content;
    }

    public void increaseReCommentCount() {
        this.reCommentCount++;
    }

    public void decreaseReCommentCount() {
        this.reCommentCount--;
    }
}
