package com.woongeya.zoing.domain.comment.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

    @Builder
    public Comment(String content, Long postId, Long userId) {
        this.content = content;
        this.postId = postId;
        this.userId = userId;
    }

    @PrePersist
    public void createAt() {
        this.createTime = LocalDateTime.now();
    }
}
