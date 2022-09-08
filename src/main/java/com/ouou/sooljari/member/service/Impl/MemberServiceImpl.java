package com.ouou.sooljari.member.service.Impl;

import com.ouou.sooljari.member.domain.Member;
import com.ouou.sooljari.member.domain.repository.MemberRepository;
import com.ouou.sooljari.member.global.jwt.JwtTokenProvider;
import com.ouou.sooljari.member.presentation.dto.request.MemberSignInRequestDto;
import com.ouou.sooljari.member.presentation.dto.request.MemberSignUpRequestDto;
import com.ouou.sooljari.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Long join(MemberSignUpRequestDto requestDto) {
        if(memberRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        Member member = memberRepository.save(requestDto.toEntity());
        member.passwordEncode(passwordEncoder);
        member.addUserAuthority();
        return member.getId();
    }

    @Transactional
    @Override
    public String login(MemberSignInRequestDto requestDto) {
        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입된 이메일이 아닙니다."));
        // 예외처리를 위한 함수 작성을 한 것이 아닌가 추정
        // validateMatchedPassword(requestDto.getPassword(), member.getPassword());

        String role = member.getRole().name();
        return jwtTokenProvider.createToken(member.getUsername(), role);
    }

}