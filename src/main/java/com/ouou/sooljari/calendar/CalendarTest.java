package com.ouou.sooljari.calendar;

import com.ouou.sooljari.calendar.entity.Calendar;
import com.ouou.sooljari.calendar.entity.CalendarRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CalendarTest {

    @Autowired
    CalendarRepo calendarRepo;

    @Test
    void save() {
        Calendar params = Calendar.builder()
                .userId(1L)
                .date("2022-11-15")
                .productId(3L)
                .diary("아주 맛있었다")
                .build();

        calendarRepo.save(params);

        Calendar entity = calendarRepo.findById((long) 3).orElse(null);
        assertThat(entity.getUserId()).isEqualTo(1L);
    }

    @Test
    void findAll() {
        long calendarCount = calendarRepo.count();

        List<Calendar> calendars = calendarRepo.findAll();
    }

    @Test
    void delete() {
        Calendar entity = calendarRepo.findById((long) 2).get();

        calendarRepo.delete(entity);
    }
}
