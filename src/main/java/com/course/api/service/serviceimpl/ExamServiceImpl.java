package com.course.api.service.serviceimpl;

import com.course.api.dto.ExamDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Exam;
import com.course.api.repository.ClazzRepository;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.ExamRepository;
import com.course.api.service.ExamService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.repository.ClassRepository;

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

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExamByClass(Integer idClass) {
        return (Exam) entityManager.createNativeQuery("select * from EXAM e join EXAM_DETAIL d on e.id_exam = d.id_exam where d.id_class =:idClass",Exam.class).setParameter("idClass",idClass).getSingleResult();
    }


    @Override
    public Exam getExamById(Integer idExam) {
        return examRepository.findExamByIdExam(idExam);
    }

    @Override
    public Exam addExam(ExamDTO examDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ExamDTO, Exam>() {
            @Override
            protected void configure() {
                skip().setIdExam(null);
            }
        });
        Exam exam = modelMapper.map(examDTO, Exam.class);
        exam.setCourse(courseRepository.findCourseByIdCourse(examDTO.getIdCourse()));
        exam.setCreatedDate(new Date());
        exam.setModifyDate(new Date());
        examRepository.save(exam);
        return exam;
    }

    @Override
    public Exam updateExam(ExamDTO examDTO, Integer idExam) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ExamDTO, Exam>() {
            @Override
            protected void configure() {
                skip().setIdExam(null);
            }
        });
        Exam exam = modelMapper.map(examDTO, Exam.class);
        exam.setIdExam(idExam);
        exam.setCourse(courseRepository.findCourseByIdCourse(examDTO.getIdCourse()));
        exam.setModifyDate(new Date());
        examRepository.save(exam);
        return exam;
    }

    @Override
    public void removeExam(Exam exam) {
        examRepository.delete(exam);
    }
}
