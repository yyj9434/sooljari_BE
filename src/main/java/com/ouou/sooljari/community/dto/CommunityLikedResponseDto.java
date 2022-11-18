package com.ouou.sooljari.community.dto;

import com.ouou.sooljari.community.entity.CommunityLiked;
import lombok.Getter;

@Getter
public class CommunityLikedResponseDto {
    private Long id;
    private String userId;
    private Long communityId;

    public CommunityLikedResponseDto(CommunityLiked entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.communityId = entity.getCommunityId();
    }
}