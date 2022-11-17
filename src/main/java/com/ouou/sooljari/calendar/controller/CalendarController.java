package com.ouou.sooljari.calendar.controller;

import com.ouou.sooljari.calendar.dto.CalendarRequestDto;
import com.ouou.sooljari.calendar.dto.CalendarResponseDto;
import com.ouou.sooljari.calendar.entity.Calendar;
import com.ouou.sooljari.calendar.model.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CalendarController {

    private final CalendarService productService;

    /**
     * product 생성
     */
    @PostMapping("/calendars")
    public Long save(@RequestBody final CalendarRequestDto params) {
        return productService.save(params);
    }

    /**
     * product 조회
     */
    @GetMapping("/calendars")
    public List<CalendarResponseDto> findAll() {
        return productService.findAll();
    }

    /**
     * product 검색
     */
    @GetMapping("/calendars/{id}")
    public Optional<Calendar> findById(@PathVariable final Long id) {
        return productService.findById(id);
    }

    /**
     * product name 검색
     */
//    @GetMapping("/products/search")
//    public String search(String name, Model model) {
//        List <Product> searchList = productService.search(name);
//
//        model.addAttribute("searchList", searchList);
//        return "products-search";
//    }

    /**
     * product 수정
     */
    @PatchMapping("/calendars/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final CalendarRequestDto params) {
        return productService.update(id, params);
    }
}
