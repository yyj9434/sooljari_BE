package com.ouou.sooljari.recommend.dto;

import com.ouou.sooljari.recommend.entity.Like;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeRequestDto {
    private Long userId;
    private Long productId;

    public Like toEntity() {
        return Like.builder()
                .userId(userId)
                .productId(productId)
                .build();
    }
}