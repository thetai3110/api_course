package com.course.api.service.serviceimpl;

import com.course.api.entity.Ca;
import com.course.api.repository.CaRepositoty;
import com.course.api.service.CaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("caService")
public class CaServiceImpl implements CaService {

    @Autowired
    private CaRepositoty caRepositoty;

    @Override
    public List<Ca> getAll() {
        return caRepositoty.findAll();
    }

    @Override
    public Ca getCaById(Integer idCa) throws Exception {
        return caRepositoty.findCaByIdCa(idCa);
    }

    @Override
    public Ca addCa(Ca ca) {
        caRepositoty.save(ca);
        return ca;
    }

    @Override
    public Ca updateCa(Ca ca) {
        caRepositoty.save(ca);
        return ca;
    }

    @Override
    public void removeCa(Ca ca) {
        caRepositoty.delete(ca);
    }
}
