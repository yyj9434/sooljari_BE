package com.ouou.sooljari.user.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JoinRepo extends JpaRepository<Join, Long> {
    Optional<Join> findById(Long id);
    boolean existsById(Long id);
    Optional<Join> findByEmail(String email);
    Optional<Join> findByUserName(String userName);
    boolean existsByEmail(String email);
}