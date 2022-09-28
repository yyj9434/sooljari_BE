package com.ouou.sooljari.community.dto;

import com.ouou.sooljari.community.entity.Community;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommunityRequestDto {

    private String user;
    private String title;
    private String image;
    private String content;
    private Integer likes;

    public Community toEntity() {
        return Community.builder()
                .user(user)
                .title(title)
                .image(image)
                .content(content)
                .likes(likes)
                .build();
    }


}
