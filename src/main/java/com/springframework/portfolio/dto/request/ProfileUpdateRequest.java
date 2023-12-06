package com.springframework.portfolio.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileUpdateRequest {

    private String name;
    private String introduction;
    private String img;

    @Builder
    public ProfileUpdateRequest(String name, String introduction, String img) {
        this.name = name;
        this.introduction = introduction;
        this.img = img;
    }
}