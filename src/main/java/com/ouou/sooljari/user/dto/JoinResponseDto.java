package com.ouou.sooljari.user.dto;

import com.ouou.sooljari.user.dto.JoinRequestDto;
import com.ouou.sooljari.user.entity.Join;
import lombok.Getter;

@Getter
public class JoinResponseDto {
    private String email;
    private String password;
    private String userName;
    private String birth;
    private String phone;

    public JoinResponseDto(Join entity) {
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.userName = entity.getUserName();
        this.birth = entity.getBirth();
        this.phone = entity.getPhone();
    }
}