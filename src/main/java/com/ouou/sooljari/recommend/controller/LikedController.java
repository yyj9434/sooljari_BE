package com.ouou.sooljari.recommend.controller;

import com.ouou.sooljari.recommend.dto.LikedRequestDto;
import com.ouou.sooljari.recommend.entity.Liked;
import com.ouou.sooljari.recommend.model.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LikedController {

    private final LikedService LikedService;

    @PostMapping("/liked")
    public Long save(@RequestBody LikedRequestDto params) {
        boolean liked = params.isLiked();
        if(liked) {
            return LikedService.save(params);
        } else {
            return LikedService.delete(params);
        }
    }

    @GetMapping("/checkLiked")
    public void checkLiked(){

    }

}