package com.course.api.service.serviceimpl;

import com.course.api.entity.Majors;
import com.course.api.repository.MajorsRepositoty;
import com.course.api.service.MajorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("majorsService")
public class MajorsServiceImpl implements MajorsService {

    @Autowired
    private MajorsRepositoty majorsRepositoty;

    @Override
    public List<Majors> getAll() {
        return majorsRepositoty.findAll();
    }

    @Override
    public Majors getMajorsById(Integer idMajors) {
        return majorsRepositoty.findMajorsByIdMajors(idMajors);
    }

    @Override
    public Majors addMajors(Majors majors) {
        majorsRepositoty.save(majors);
        return majors;
    }

    @Override
    public Majors updateMajors(Majors majors) {
        majorsRepositoty.save(majors);
        return majors;
    }

    @Override
    public void removeMajors(Majors majors) {
        majorsRepositoty.delete(majors);
    }
}
