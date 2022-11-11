package com.ouou.sooljari.recommend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="like")
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;
    private Long productId;

    @Builder
    public Like(Long userId, Long productId) {
        this.productId = productId;
        this.userId = userId;
    }

}