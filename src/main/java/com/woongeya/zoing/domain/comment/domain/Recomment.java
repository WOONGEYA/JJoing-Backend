package com.woongeya.zoing.domain.comment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recomment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recomment_id")
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    private Long userId;

    public Recomment(String content, Comment comment, Long userId) {
        this.content = content;
        this.comment = comment;
        this.userId = userId;
    }
}
