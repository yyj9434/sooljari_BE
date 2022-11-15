package com.ouou.sooljari.calendar.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CalendarRepo extends JpaRepository<Calendar, Long> {
    Optional<Calendar> findById(Long id);
}
