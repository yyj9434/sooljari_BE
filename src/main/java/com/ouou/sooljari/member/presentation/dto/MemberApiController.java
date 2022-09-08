package com.ouou.sooljari.member.presentation.dto;

import com.ouou.sooljari.member.presentation.dto.request.MemberSignUpRequestDto;
import com.ouou.sooljari.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    public Long join(@RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.join(requestDto);
    }
}