package com.springframework.portfolio.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryAddRequest {

    private String name;

    @Builder
    public CategoryAddRequest(String name) {

        this.name = name;
    }
}
