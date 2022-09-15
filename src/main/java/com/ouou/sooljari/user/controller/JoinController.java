package com.ouou.sooljari.user.controller;

import com.ouou.sooljari.user.dto.JoinRequestDto;
import com.ouou.sooljari.user.dto.JoinResponseDto;
import com.ouou.sooljari.user.model.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public Long save(@RequestBody final JoinRequestDto params) {
        return joinService.save(params);
    }

    @GetMapping("/join")
    public List<JoinResponseDto> getAllUsers() {
        return joinService.getAllUsers();
    }
}