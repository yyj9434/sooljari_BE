package com.ouou.sooljari.recommend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "userEmail")
@RestController
@RequestMapping("/api")
public class LikeController {

    @PostMapping("/liked")
    public void Like() {

    }

}