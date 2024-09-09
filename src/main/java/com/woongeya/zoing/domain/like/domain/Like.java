package com.woongeya.zoing.domain.like.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Getter
@Table(name = "like_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    private Long userId;

    private Long projectId;

    @Builder
    public Like(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
