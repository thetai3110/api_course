package com.course.api.repository;

import com.course.api.entity.Ca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaRepositoty extends JpaRepository<Ca, Integer> {
    Ca findCaByIdCa(Integer idCa);
}
