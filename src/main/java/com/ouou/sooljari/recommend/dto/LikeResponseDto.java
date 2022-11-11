package com.ouou.sooljari.recommend.dto;

import com.ouou.sooljari.recommend.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponseDto {
    private Long id;
    private Long userId;
    private Long productId;

    public LikeResponseDto(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.productId = entity.getProductId();
    }
}