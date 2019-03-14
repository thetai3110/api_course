package com.course.api.service.serviceimpl;

import com.course.api.entity.Course;
import com.course.api.entity.Marks;
import com.course.api.entity.Student;
import com.course.api.repository.MarksRepository;
import com.course.api.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("marksService")
public class MarksServiceImpl implements MarksService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public List<Marks> getAll() {
        return marksRepository.findAll();
    }

    @Override
    public Marks getMarksById(Integer idMarks) {
        return marksRepository.findMarksByIdMarks(idMarks);
    }

    @Override
    public List<Marks> getMarksByCourse(Integer idCourse) {
        return entityManager.createNativeQuery("select * from MARKS where id_course =:idCourse",Marks.class).setParameter("idCourse", idCourse).getResultList();
    }

    @Override
    public List<Marks> getMarksByStudent(Integer idStudent) {
        return entityManager.createNativeQuery("select * from MARKS where id_student =:idStudent",Marks.class).setParameter("idStudent", idStudent).getResultList();
    }

    @Override
    public Marks addMarks(Marks marks) {
        marks.setCreatedDate(new Date());
        marks.setModifyDate(new Date());
        marksRepository.save(marks);
        return marks;
    }

    @Override
    public Marks updateMarks(Marks marks) {
        marks.setModifyDate(new Date());
        marksRepository.save(marks);
        return marks;
    }

    @Override
    public void removeMarks(Marks marks) {
        marksRepository.delete(marks);
    }
}
