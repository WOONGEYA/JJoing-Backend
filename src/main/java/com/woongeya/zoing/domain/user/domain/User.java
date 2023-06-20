package com.woongeya.zoing.domain.user.domain;

import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.domain.user.presetation.dto.request.UpdateUserRequestDto;
import com.woongeya.zoing.global.oauth.OAuthAttributes;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    public User(String name, String nickName, String email, String school, int age, String major, Authority authority) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.school = school;
        this.age = age;
        this.major = major;
        this.authority = authority;
    }

    public User update(OAuthAttributes oAuthAttributes, String school) {
        this.email = oAuthAttributes.getEmail();
        this.name = oAuthAttributes.getName();
        this.nickName = oAuthAttributes.getName();
        this.school = school;
        return this;
    }

    public void updateInfo(UpdateUserRequestDto request) {
        this.name = request.getName();
        this.nickName = request.getNickname();
        this.school = request.getSchool();
        this.age = request.getAge();
        this.major = request.getMajor();
    }
}
