package com.ouou.sooljari.community.dto;

import com.ouou.sooljari.community.entity.CommunityLiked;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommunityLikedRequestDto {
    private String userId;
    private Long communityId;

    private boolean liked;

    public CommunityLiked toEntity() {
        return CommunityLiked.builder()
                .userId(userId)
                .communityId(communityId)
                .liked(liked)
                .build();
    }
}