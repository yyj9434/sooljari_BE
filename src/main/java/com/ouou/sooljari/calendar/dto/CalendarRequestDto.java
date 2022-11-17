package com.ouou.sooljari.calendar.dto;

import com.ouou.sooljari.calendar.entity.Calendar;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CalendarRequestDto {

    private String userName;
    private String date;
    private Long productId;
    private String diary;

    public Calendar toEntity() {
        return Calendar.builder()
                .userName(userName)
                .date(date)
                .productId(productId)
                .diary(diary)
                .build();
    }


}
