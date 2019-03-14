package com.course.api.service.serviceimpl;

import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;
import com.course.api.repository.ExamRepository;
import com.course.api.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("examService")
public class ExamServiceImpl implements ExamService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ExamRepository examRepository;

    @Override
    public List<Exam> getAll() {
        return null;
    }

    @Override
    public Exam getExamByClass(Integer idClazz) throws Exception {
        return (Exam) entityManager.createNativeQuery("select * from EXAM where id_class =:idClazz",Exam.class).setParameter("idClazz",idClazz).getSingleResult();
    }


    @Override
    public Exam getExamById(Integer idExam) {
        return examRepository.findExamByIdExam(idExam);
    }

    @Override
    public Exam addExam(Exam exam) {
        exam.setCreatedDate(new Date());
        exam.setModifyDate(new Date());
        examRepository.save(exam);
        return exam;
    }

    @Override
    public Exam updateExam(Exam exam) {
        exam.setModifyDate(new Date());
        examRepository.save(exam);
        return exam;
    }

    @Override
    public void removeExam(Exam exam) {
        examRepository.delete(exam);
    }
}
