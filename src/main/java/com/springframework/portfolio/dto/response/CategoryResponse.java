package com.springframework.portfolio.dto.response;

import com.springframework.portfolio.entity.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryResponse {

    private Long num;
    private String name;

    @Builder
    public CategoryResponse(Long num, String name) {
        this.num = num;
        this.name = name;
    }

    public CategoryResponse(Category category) {
        this.num = category.getNum();
        this.name = category.getName();
    }
}
