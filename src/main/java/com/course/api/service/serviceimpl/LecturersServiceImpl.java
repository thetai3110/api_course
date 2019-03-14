package com.course.api.service.serviceimpl;

import com.course.api.entity.Lecturers;
import com.course.api.entity.Majors;
import com.course.api.repository.LecturersRepository;
import com.course.api.service.LecturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("lecturersService")
public class LecturersServiceImpl implements LecturersService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LecturersRepository lecturersRepository;

    @Override
    public List<Lecturers> getAll() {
        return lecturersRepository.findAll();
    }

    @Override
    public Lecturers getLecturersById(Integer idLec) {
        return lecturersRepository.findLecturersByIdLecturers(idLec);
    }

    @Override
    public List<Lecturers> getByMajors(Integer idMajors) {
        return entityManager.createNativeQuery("select * from LECTURERS where id_majors =:idMajors",Lecturers.class).setParameter("idMajors",idMajors).getResultList();
    }

    @Override
    public Lecturers addLecturers(Lecturers lecturers) {
        lecturers.setCreatedDate(new Date());
        lecturers.setModifyDate(new Date());
        lecturersRepository.save(lecturers);
        return lecturers;
    }

    @Override
    public Lecturers updateLecturers(Lecturers lecturers)  {
        lecturers.setModifyDate(new Date());
        lecturersRepository.save(lecturers);
        return lecturers;
    }

    @Override
    public void removeLecturers(Lecturers lecturers) {
        lecturersRepository.delete(lecturers);
    }
}
