package com.woongeya.zoing.domain.post.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 1000)
    private String content;

    private Integer viewCount;

    private String imgUrl;

    @CreatedDate
    private LocalDateTime createTime;

    private Long userId;

    @Builder
    public Post(String title, String content, Integer viewCount, String imgUrl, LocalDateTime createTime, Long userId) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.userId = userId;
    }

    @PrePersist
    public void createAt() {
        this.createTime = LocalDateTime.now();
    }
}
