package com.ouou.sooljari.recommend.controller;

import com.ouou.sooljari.recommend.dto.LikedRequestDto;
import com.ouou.sooljari.recommend.entity.Liked;
import com.ouou.sooljari.recommend.model.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LikedController {

    @Autowired
    private final LikedService LikedService;

    @PostMapping("/liked")
    public void save(@RequestBody LikedRequestDto params) {
        boolean liked = params.isLiked();
        if(liked) {
            LikedService.save(params);
        } else {
            LikedService.delete(params);
        }
    }

    @GetMapping("/checkLiked")
    public void checkLiked(){

    }

}