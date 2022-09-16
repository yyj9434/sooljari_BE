package com.ouou.sooljari.user.model;

import com.ouou.sooljari.user.dto.JoinRequestDto;
import com.ouou.sooljari.user.dto.JoinResponseDto;
import com.ouou.sooljari.user.dto.TokenDto;
import com.ouou.sooljari.user.entity.Join;
import com.ouou.sooljari.user.entity.JoinRepo;
import com.ouou.sooljari.user.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final JoinRepo joinRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public JoinResponseDto join(JoinRequestDto requestDto) {
        if (joinRepo.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        Join join = requestDto.toEntity(passwordEncoder);
        return JoinResponseDto.of(joinRepo.save(join));
    }

    public TokenDto login(JoinRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }

}