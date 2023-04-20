package com.woongeya.zoing.domain.user.domain;

import com.woongeya.zoing.domain.user.domain.autority.Authority;
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

    @Column(unique = true, length = 32)
    private String email;

    @Column(length = 16)
    private String password;

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
    public User(Long id, String name, String email, String password, String school, int age, String major, Authority authority) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.school = school;
        this.age = age;
        this.major = major;
        this.authority = authority;
    }
}
