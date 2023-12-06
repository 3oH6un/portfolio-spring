package com.springframework.portfolio.dto.response;

import com.springframework.portfolio.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponse {

    private Long num;
    private String title;
    private Long category;
    private String description;
    private String repImg;
    private String content;

    @Builder
    public PostResponse(Long num, String title, Long category, String description, String repImg, String content) {
        this.num = num;
        this.title = title;
        this.description = description;
        this.category = category;
        this.repImg = repImg;
        this.content = content;
    }

    public PostResponse(Post post) {
        this.num = post.getNum();
        this.category = post.getCategory().getNum();
        this.repImg = post.getRepImg();
        this.description = post.getDescription();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
