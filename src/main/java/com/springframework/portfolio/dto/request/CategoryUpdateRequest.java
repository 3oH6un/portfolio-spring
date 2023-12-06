package com.springframework.portfolio.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryUpdateRequest {

    private String name;

    @Builder
    public CategoryUpdateRequest(String name) {

        this.name = name;
    }
}
