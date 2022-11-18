package com.ouou.sooljari.community.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="communityLiked")
@Builder
public class CommunityLiked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;
    private Long communityId;

    private boolean liked;

    @Builder
    public CommunityLiked(String userId, Long communityId) {
        this.communityId = communityId;
        this.userId = userId;
    }

}