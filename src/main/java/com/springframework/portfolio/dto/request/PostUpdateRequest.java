package com.springframework.portfolio.dto.request;

import com.springframework.portfolio.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUpdateRequest {

    private String title;
    private Long category;
    private String repImg;
    private String description;
    private String content;

    @Builder
    public PostUpdateRequest(String title, Long category, String repImg, String description, String content) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.repImg = repImg;
        this.content = content;
    }
}
