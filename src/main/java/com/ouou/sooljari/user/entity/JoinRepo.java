package com.ouou.sooljari.user.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinRepo extends JpaRepository<Join, Long> {
    Optional<Join> findById(Long id);
}