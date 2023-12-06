package com.springframework.portfolio.entity;

import com.springframework.portfolio.common.entity.BaseTimeEntity;
import com.springframework.portfolio.dto.PostDto;
import com.springframework.portfolio.dto.request.PostUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private String description;

    private String repImg;

    @Column(nullable = false, length = 12000)
    private String content;

    @Builder
    public Post(String title, Category category, String description, String repImg, String content) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.repImg = repImg;
        this.content = content;
    }

    public Post updatePost(PostDto request) {
        this.title = request.getTitle();
        this.category = request.getCategory();
        this.repImg = request.getRepImg();
        this.content = request.getContent();
        return this;
    }
}
