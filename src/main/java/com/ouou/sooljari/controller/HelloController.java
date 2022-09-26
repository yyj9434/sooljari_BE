package com.ouou.sooljari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("/api/testConnection")
    public String time() {
        return "안녕하세요. 현재 서버의 시간은 " + new Date() + " 입니다!!!!!!";
    }

    @GetMapping("/api")
    public String loginTest() { return "hello test"; }
}
