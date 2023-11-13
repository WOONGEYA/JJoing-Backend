package com.woongeya.zoing.domain.comment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recomment_id")
    private Long id;

    private String content;

    private Long commentId;

    private Long userId;

    public ReComment(String content, Long commentId, Long userId) {
        this.content = content;
        this.commentId = commentId;
        this.userId = userId;
    }
}
