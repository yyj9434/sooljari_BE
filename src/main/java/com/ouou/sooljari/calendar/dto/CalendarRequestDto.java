package com.ouou.sooljari.calendar.dto;

import com.ouou.sooljari.calendar.entity.Calendar;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CalendarRequestDto {

    private Long userId;
    private String date;
    private Long productId;
    private String diary;

    public Calendar toEntity() {
        return Calendar.builder()
                .userId(userId)
                .date(date)
                .productId(productId)
                .diary(diary)
                .build();
    }


}
