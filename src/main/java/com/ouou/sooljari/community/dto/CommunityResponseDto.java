package com.ouou.sooljari.community.dto;

import com.ouou.sooljari.community.entity.Community;
import lombok.Getter;

@Getter
public class CommunityResponseDto {

    private Long id;
    private String user;
    private String title;
    private String image;
    private String content;
    private Integer likes;

    public CommunityResponseDto(Community entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.title = entity.getTitle();
        this.image = entity.getImage();
        this.content = entity.getContent();
        this.likes = entity.getLikes();
    }
}
