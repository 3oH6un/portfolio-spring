package com.springframework.portfolio.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostAddRequest {

    private String title;
    private Long category;
    private String description;
    private String content;
    private String[] uploadedImgs;
    private String[] usedImgs;
}
