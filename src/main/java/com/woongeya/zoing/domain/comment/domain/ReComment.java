package com.woongeya.zoing.domain.comment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recomment_id")
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(nullable = false)
    private Long commentId;

    @Column(nullable = false)
    private Long userId;

    public ReComment(String content, Long commentId, Long userId) {
        this.content = content;
        this.commentId = commentId;
        this.userId = userId;
    }

    @PrePersist
    public void createAt() {
        this.createTime = LocalDateTime.now();
    }
}
