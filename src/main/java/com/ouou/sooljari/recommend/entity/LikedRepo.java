package com.ouou.sooljari.recommend.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikedRepo extends JpaRepository<Liked, Long> {
    Optional<Liked> findById(Long id);
}