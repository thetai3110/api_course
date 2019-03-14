package com.course.api.repository;

import com.course.api.entity.Ca;
import com.course.api.entity.ClassDay;
import com.course.api.entity.SchoolDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassDayRepository extends JpaRepository<ClassDay, Integer> {
    ClassDay findClassDayByIdClassDay(Integer idClassDay);
    List<ClassDay> findClassDayBySchoolDay(SchoolDay schoolDay);
    List<ClassDay> findClassDayByCa(Ca ca);
    List<ClassDay> findClassDayByIdClass(Integer idClass);
}
