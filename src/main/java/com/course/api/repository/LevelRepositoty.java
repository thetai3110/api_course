package com.course.api.repository;

import com.course.api.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepositoty extends JpaRepository<Level, Integer> {
    Level findAllByIdLevel(Integer id);
}
