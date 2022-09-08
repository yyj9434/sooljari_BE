package com.ouou.sooljari.member.presentation.dto.response;

import com.ouou.sooljari.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberSignUpResponseDto {

    private Long id;
    private String email;
    private String nickname;
    private int age;
    private String password;

    public MemberSignUpResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getUsername();  //not official(-> getEmail)
        this.nickname = member.getNickname();
        this.age = member.getAge();
        this.password = member.getPassword();
    }
}