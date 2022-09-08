package com.ouou.sooljari.join;

import java.util.Map;

public interface MemberService {

    // 회원가입
    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;
    public String login(Map<String, String> members);
}