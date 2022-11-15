package com.ouou.sooljari.calendar.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="calendar")
@Builder
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;
    private String date;
    private Long productId;
    private String diary;


    @Builder
    public Calendar(Long userId, String date, Long productId, String diary) {
        this.userId = userId;
        this.date = date;
        this.productId = productId;
        this.diary = diary;
    }

    public void update(Long userId, String date, Long productId, String diary) {
        this.userId = userId;
        this.date = date;
        this.productId = productId;
        this.diary = diary;
    }
}
