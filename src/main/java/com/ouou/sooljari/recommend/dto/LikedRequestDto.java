package com.ouou.sooljari.recommend.dto;

import com.ouou.sooljari.recommend.entity.Liked;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikedRequestDto {
    private String userId;
    private Long productId;

    private boolean liked;

    public Liked toEntity() {
        return Liked.builder()
                .userId(userId)
                .productId(productId)
                .liked(liked)
                .build();
    }
}