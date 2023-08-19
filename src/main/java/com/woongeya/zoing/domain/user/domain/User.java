package com.woongeya.zoing.domain.user.domain;

import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.global.feign.dto.response.GoogleInfoResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(length = 32)
    private String school;

    @Column(length = 8)
    private int age;

    @Column(length = 64)
    private String major;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String name, String nickName, String email, String githubUrl, String statusMessage, String imgUrl, String school, int age, String major, Authority authority) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.githubUrl = githubUrl;
        this.statusMessage = statusMessage;
        this.imgUrl = imgUrl;
        this.school = school;
        this.age = age;
        this.major = major;
        this.authority = authority;
    }

    public User update(GoogleInfoResponseDto response, String school) {
        this.email = response.getEmail();
        this.name = response.getName();
        this.nickName = response.getName();
        this.school = school;
        return this;
    }

    public void updateInfo(UpdateUserRequestDto request) {
        this.nickName = request.getNickname();
        this.age = request.getAge();
        this.major = request.getMajor();
        this.githubUrl = request.getGithubUrl();
        this.statusMessage = request.getStatusMessage();
        this.imgUrl = request.getImageUrl();
    }
}
