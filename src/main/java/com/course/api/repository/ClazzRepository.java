package com.course.api.repository;

import com.course.api.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    Clazz findClazzByIdClass(Integer idClazz);
}
