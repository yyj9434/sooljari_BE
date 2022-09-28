package com.ouou.sooljari.community.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommunityRepo extends JpaRepository<Community, Long> {
    Optional<Community> findById(Long id);
}
