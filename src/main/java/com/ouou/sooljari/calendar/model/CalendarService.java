package com.ouou.sooljari.calendar.model;

import com.ouou.sooljari.calendar.dto.CalendarRequestDto;
import com.ouou.sooljari.calendar.dto.CalendarResponseDto;
import com.ouou.sooljari.calendar.entity.Calendar;
import com.ouou.sooljari.calendar.entity.CalendarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepo calendarRepo;

    /**
     * calendar 생성
     */
    @Transactional
    public Long save(final CalendarRequestDto params) {
        Calendar entity = calendarRepo.save(params.toEntity());
        return entity.getId();
    }

    /**
     * calendar 리스트 조회
     */
    public List<CalendarResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Calendar> list = calendarRepo.findAll(sort);
        return list.stream().map(CalendarResponseDto::new).collect(Collectors.toList());
    }

    /**
     * calendar id 검색
     */
    public Optional <Calendar> findById(Long id) {
        return calendarRepo.findById(id);
    }

    /**
     * calendar name 검색
     */
//    public List<Product> search(String name) {
//        List<Product> ProductList = productRepo.findByTitleContaining(name);
//        return ProductList;
//    }

    /**
     * calendar 수정
     */
    @Transactional
    public Long update(final Long id, final CalendarRequestDto params) {
        Calendar entity = calendarRepo.findById(id).orElseThrow();
        entity.update(params.getUserName(), params.getDate(), params.getProductId(), params.getDiary());
        return id;
    }
}
