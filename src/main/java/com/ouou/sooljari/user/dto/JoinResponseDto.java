package com.ouou.sooljari.user.dto;

import com.ouou.sooljari.user.dto.JoinRequestDto;
import com.ouou.sooljari.user.entity.Join;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinResponseDto {
    private String email;
    private String password;
    private String userName;
    private String birth;
    private String phone;

    public static JoinResponseDto of(Join join) {
        return JoinResponseDto.builder()
                .email(join.getEmail())
                .password(join.getPassword())
                .userName(join.getUserName())
                .birth(join.getBirth())
                .phone(join.getPhone())
                .build();
    }

    public JoinResponseDto (Join entity) {
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.userName = entity.getUserName();
        this.birth = entity.getBirth();
        this.phone = entity.getPhone();
    }
}