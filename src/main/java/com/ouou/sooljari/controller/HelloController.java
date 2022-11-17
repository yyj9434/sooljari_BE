package com.ouou.sooljari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/api/testConnection")
    public String time() {
        return "안녕하세요. 현재 서버의 시간은 " + new Date() + " 입니다!!!!!!";
    }

    @GetMapping("/api")
    public String loginTest() { return "hello test"; }

    @GetMapping("/api/testFlask")
    public String testFlak(@RequestParam(value="id", required = false) String id) {
        String getId = id;
        System.out.println("Select ProductId is " + id);
        return "Flask Connect";
    }
}
