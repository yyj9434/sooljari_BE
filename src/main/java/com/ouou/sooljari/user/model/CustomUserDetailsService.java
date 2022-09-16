package com.ouou.sooljari.user.model;

import com.ouou.sooljari.user.entity.Join;
import com.ouou.sooljari.user.entity.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final JoinRepo joinRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return joinRepo.findByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(()-> new UsernameNotFoundException(username + "을 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(Join join) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(join.getAuthority().toString());

        return new User(
                String.valueOf(join.getId()),
                join.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}