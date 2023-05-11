package com.woongeya.zoing.domain.user.domain;

import com.woongeya.zoing.domain.user.domain.autority.Authority;
import com.woongeya.zoing.global.oauth.OAuthAttributes;
import lombok.*;

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
    public User(Long id, String name, String nickName, String email, String school, int age, String major, Authority authority) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.school = school;
        this.age = age;
        this.major = major;
        this.authority = authority;
    }

    public User update(OAuthAttributes oAuthAttributes) {
        this.email = oAuthAttributes.getEmail();
        this.name = oAuthAttributes.getName();
        this.nickName = oAuthAttributes.getName();
        return this;
    }
}
