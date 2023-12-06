package com.springframework.portfolio.entity;

import com.springframework.portfolio.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }

    public Category updateCategory(String name) {
        this.name = name;
        return this;
    }
}
