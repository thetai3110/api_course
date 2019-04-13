package com.course.api.repository;

import com.course.api.entity.EducationProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationProgramRepository extends JpaRepository<EducationProgram, Integer> {
    EducationProgram findEducationProgramByIdEdu(Integer id);
}
