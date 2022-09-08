package com.ouou.sooljari.member.service;

import com.ouou.sooljari.member.presentation.dto.request.MemberSignInRequestDto;
import com.ouou.sooljari.member.presentation.dto.request.MemberSignUpRequestDto;

public interface MemberService {

    Long join(MemberSignUpRequestDto requestDto);
    String login(MemberSignInRequestDto requestDto);
}