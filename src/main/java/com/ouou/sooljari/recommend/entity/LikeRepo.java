package com.ouou.sooljari.recommend.entity;

import com.ouou.sooljari.recommend.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Long> {
    Optional<Like> findById(Long id);
}