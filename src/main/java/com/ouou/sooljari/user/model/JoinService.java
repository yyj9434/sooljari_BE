package com.ouou.sooljari.user.model;

import com.ouou.sooljari.user.config.SecurityUtil;
import com.ouou.sooljari.user.dto.JoinRequestDto;
import com.ouou.sooljari.user.dto.JoinResponseDto;
import com.ouou.sooljari.user.entity.Join;
import com.ouou.sooljari.user.entity.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepo joinRepo;
    private final PasswordEncoder passwordEncoder;

    public JoinResponseDto getMyInfoBySecurity() {
        return joinRepo.findById(SecurityUtil.getCurrentMemberId())
                .map(JoinResponseDto::of)
                .orElseThrow(()-> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

     //회원 생성

    @Transactional
    public Long save(final JoinRequestDto params) {
        Join entity = joinRepo.save(params.toEntity(passwordEncoder));
        return entity.getId();
    }

    // 회원 정보 가져오기

    public List<JoinResponseDto> getAllUsers() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Join> list = joinRepo.findAll(sort);
        return list.stream().map(JoinResponseDto::new).collect(Collectors.toList());
    }
}