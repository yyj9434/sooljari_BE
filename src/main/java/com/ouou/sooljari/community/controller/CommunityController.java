package com.ouou.sooljari.community.controller;

import com.ouou.sooljari.community.dto.CommunityLikedRequestDto;
import com.ouou.sooljari.community.dto.CommunityRequestDto;
import com.ouou.sooljari.community.dto.CommunityResponseDto;
import com.ouou.sooljari.community.entity.Community;
import com.ouou.sooljari.community.entity.CommunityLiked;
import com.ouou.sooljari.community.model.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CommunityController {

    @Autowired
    private final CommunityService communityService;


    /**
     * Community 생성
     */
    @PostMapping("/community")
    public Long save(@RequestBody final CommunityRequestDto params) {
        return communityService.save(params);
    }

    /**
     * Community 조회
     */
    @GetMapping("/community")
    public List<CommunityResponseDto> findAll() {
        return communityService.findAll();
    }

    /**
     * Community 검색
     */
    @GetMapping("/community/{id}")
    public Optional<Community> findById(@PathVariable final Long id) {
        return communityService.findById(id);
    }

    /**
     * Community name 검색
     */
//    @GetMapping("/products/search")
//    public String search(String name, Model model) {
//        List <Product> searchList = productService.search(name);
//
//        model.addAttribute("searchList", searchList);
//        return "products-search";
//    }

    /**
     * Community 수정
     */
    @PatchMapping("/community/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final CommunityRequestDto params) {
        return communityService.update(id, params);
    }

    @PostMapping("/communityLiked")
    public void likedSave(@RequestBody CommunityLikedRequestDto params) {
        boolean liked = params.isLiked();
        if(liked) {
            communityService.likedSave(params);
        } else {
            communityService.likedDelete(params);
        }
    }

    @PostMapping("/countCommunityLiked")
    public String countCommunityliked(@RequestBody CommunityLikedRequestDto params) {
        System.out.println(communityService.countCommunityliked(params));
        return communityService.countCommunityliked(params);
    }
}
