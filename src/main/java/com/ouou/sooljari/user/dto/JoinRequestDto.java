package com.ouou.sooljari.user.dto;

import com.ouou.sooljari.user.entity.Authority;
import com.ouou.sooljari.user.entity.Join;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
public class JoinRequestDto {
    private String email;
    private String password;
    private String userName;
    private String birth;
    private String phone;

    public Join toEntity(PasswordEncoder passwordEncoder) {
        return Join.builder()
                .email(email)
                .password(password)
                .userName(userName)
                .birth(birth)
                .phone(phone)
                .authority(Authority.ROLE_USER)
                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}