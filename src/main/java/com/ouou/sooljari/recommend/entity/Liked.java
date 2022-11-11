package com.ouou.sooljari.recommend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="liked")
@Builder
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;
    private Long productId;

    private boolean liked;

    @Builder
    public Liked(String userId, Long productId) {
        this.productId = productId;
        this.userId = userId;
    }

}