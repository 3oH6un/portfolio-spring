package com.springframework.portfolio.dto;

import com.springframework.portfolio.entity.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostDto {

    private String title;
    private Category category;
    private String repImg;
    private String content;

    @Builder
    public PostDto(String title, Category category, String repImg, String content) {
        this.title = title;
        this.category = category;
        this.repImg = repImg;
        this.content = content;
    }
}
