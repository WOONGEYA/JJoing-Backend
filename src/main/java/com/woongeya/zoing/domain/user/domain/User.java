package com.woongeya.zoing.domain.user.domain;

import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequest;
import com.woongeya.zoing.global.feign.dto.response.GoogleInfoResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 16)
    private String name;

    @Column(length = 16)
    private String nickName;

    @Column(unique = true, length = 32)
    private String email;

    @Column(length = 50)
    private String githubUrl;

    @Column(length = 100)
    private String statusMessage;

    @Column(nullable = false)
    private String imgUrl;

    @Column(length = 8)
    private int age;

    @Column(length = 64)
    private String major;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String name, String nickName, String email, String githubUrl, String statusMessage, String imgUrl, int age, String major, Authority authority) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.githubUrl = githubUrl;
        this.statusMessage = statusMessage;
        this.imgUrl = imgUrl;
        this.age = age;
        this.major = major;
        this.authority = authority;
    }

    public User update(GoogleInfoResponse response) {
        this.email = response.getEmail();
        this.name = response.getName();
        return this;
    }

    public void updateInfo(UpdateUserRequest request) {
        this.nickName = request.nickName();
        this.age = request.age();
        this.major = request.major();
        this.githubUrl = request.githubUrl();
        this.statusMessage = request.statusMessage();
        this.imgUrl = request.imageUrl();
    }
}
