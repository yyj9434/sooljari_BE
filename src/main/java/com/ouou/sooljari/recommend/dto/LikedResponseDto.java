package com.ouou.sooljari.recommend.dto;

import com.ouou.sooljari.recommend.entity.Liked;
import lombok.Getter;

@Getter
public class LikedResponseDto {
    private Long id;
    private String userId;
    private Long productId;

    public LikedResponseDto(Liked entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.productId = entity.getProductId();
    }
}