package com.course.api.service.serviceimpl;

import com.course.api.entity.SchoolDay;
import com.course.api.repository.SchoolDayRepository;
import com.course.api.service.SchoolDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("schoolDayService")
public class SchoolDayServiceImpl implements SchoolDayService {

    @Autowired
    private SchoolDayRepository schoolDayRepository;

    @Override
    public List<SchoolDay> getAll() {
        return schoolDayRepository.findAll();
    }

    @Override
    public SchoolDay getSchoolDayById(Integer idSchoolDay) {
        return schoolDayRepository.findSchoolDayByIdSchoolDay(idSchoolDay);
    }

    @Override
    public SchoolDay addSchoolDay(SchoolDay schoolDay) {
        schoolDayRepository.save(schoolDay);
        return schoolDay;
    }

    @Override
    public SchoolDay updateSchoolDay(SchoolDay schoolDay) {
        schoolDayRepository.save(schoolDay);
        return schoolDay;
    }

    @Override
    public void removeSchoolDay(SchoolDay schoolDay) {
        schoolDayRepository.delete(schoolDay);
    }
}
