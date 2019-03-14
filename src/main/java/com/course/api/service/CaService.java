package com.course.api.service;

import com.course.api.entity.Ca;

import java.util.List;

public interface CaService {
    List<Ca> getAll() throws Exception;
    Ca getCaById(Integer idCa) throws Exception;
    Ca addCa(Ca ca) throws Exception;
    Ca updateCa(Ca ca) throws Exception;
    void removeCa(Ca ca) throws Exception;
}
