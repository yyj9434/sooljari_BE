package com.ouou.sooljari.community.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="community")
@Builder
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user;
    private String title;
    private String image;
    private String content;
    private Integer likes;

    @Builder
    public Community(String user, String title, String image, String content, Integer likes) {
        this.user = user;
        this.title = title;
        this.image = image;
        this.content = content;
        this.likes = likes;
    }

    public void update(String user, String title, String image, String content, Integer likes) {
        this.user = user;
        this.title = title;
        this.image = image;
        this.content = content;
        this.likes = likes;
    }
}
