package com.course.api.repository;

import com.course.api.entity.Clazz;
import com.course.api.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    Clazz findClazzByIdClass(Integer idClazz);
    List<Clazz> findClazzByRoom(Room room);
    List<Clazz> findClazzByStatus(Integer status);
}
