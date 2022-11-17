package com.ouou.sooljari.calendar.dto;

import com.ouou.sooljari.calendar.entity.Calendar;
import lombok.Getter;

@Getter
public class CalendarResponseDto {

    private Long id;
    private String userName;
    private String date;
    private Long productId;
    private String diary;

    public CalendarResponseDto(Calendar entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
        this.date = entity.getDate();
        this.productId = entity.getProductId();
        this.diary = entity.getDiary();
    }
}
