package com.ouou.sooljari.recommend.controller;

import com.ouou.sooljari.recommend.dto.LikeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "userEmail")
@RestController
@RequestMapping("/api")
public class LikeController {

    @PostMapping("/liked")
    public void Like(@CookieValue("userEmail") String email, Long id, Boolean liked) {
//        if(liked == true) {
//            LikeRequestDto params =
//        } else if (liked == false) {
//
//        }
    }

    @GetMapping("/checkLiked")
    public void checkLiked(){

    }

}