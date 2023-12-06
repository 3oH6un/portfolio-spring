package com.springframework.portfolio.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String name;
    private String introduction;
    private String img;

    @Builder
    public Profile(String name, String introduction, String img) {
        this.name = name;
        this.introduction = introduction;
        this.img = img;
    }

    public Profile updateProfile(String name, String introduction, String img) {
        this.name = name;
        this.introduction = introduction;
        this.img = img;
        return this;
    }
}
