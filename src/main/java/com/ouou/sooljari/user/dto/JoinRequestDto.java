package com.ouou.sooljari.user.dto;

import com.ouou.sooljari.user.entity.Join;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequestDto {
    private String email;
    private String password;
    private String userName;
    private String birth;
    private String phone;

    public Join toEntity() {
        return Join.builder()
                .email(email)
                .password(password)
                .userName(userName)
                .birth(birth)
                .phone(phone)
                .build();
    }

}