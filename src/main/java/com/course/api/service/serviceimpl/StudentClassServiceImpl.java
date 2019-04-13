package com.course.api.service.serviceimpl;

import com.course.api.dto.ClassStudentDTO;
import com.course.api.dto.ClassCourseStudentDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.StudentClass;
import com.course.api.repository.StudentClassRepository;
import com.course.api.service.ClassService;
import com.course.api.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("studentClassService")
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private ClassService classService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentClass> getAll() {
        return studentClassRepository.findAll();
    }

    @Override
    public StudentClass getStudentClassById(Integer idStudentClass) {
        return studentClassRepository.findStudentClassByIdStudentClass(idStudentClass);
    }

    @Override
    public List<ClassStudentDTO> getStudentByClass(Integer idClass) {
        String query = "SELECT * FROM STUDENT join STUDENT_CLASS on STUDENT.id_student = STUDENT_CLASS.id_student WHERE STUDENT_CLASS.id_class =:idClass";
        return entityManager.createNativeQuery(query, ClassStudentDTO.class).setParameter("idClass", idClass).getResultList();
    }

    @Override
    public List<ClassCourseStudentDTO> getClassByStudent(Integer idStudent) {
        String query = "SELECT * FROM CLASS join STUDENT_CLASS on CLASS.id_class = STUDENT_CLASS.id_class join COURSE on CLASS.id_course = COURSE.id_course join LEVELCOURSE on COURSE.id_level = LEVELCOURSE.id_level WHERE STUDENT_CLASS.id_student =:idStudent";
        return entityManager.createNativeQuery(query, ClassCourseStudentDTO.class).setParameter("idStudent", idStudent).getResultList();
    }

    @Override
    public StudentClass getStudentClassByStudentAndClass(Integer idStudent, Integer idClass) {
        return studentClassRepository.findStudentClassByIdStudentAndIdClass(idStudent,idClass);
    }

    @Override
    public StudentClass addStudentClass(StudentClass studentClass) throws Exception {
        studentClass.setCreatedDate(new Date());
        studentClass.setModifyDate(new Date());
        studentClassRepository.save(studentClass);
        Clazz clazz = classService.getClassById(studentClass.getIdClass());
        clazz.setSize(studentClassRepository.findStudentClassByIdClass(studentClass.getIdClass()).size());
        classService.updateClass(clazz);
        return studentClass;
    }

    @Override
    public StudentClass updateStudentClass(StudentClass studentClass) {
        studentClass.setModifyDate(new Date());
        studentClassRepository.save(studentClass);
        return studentClass;
    }


    @Override
    public void removeStudentClass(StudentClass studentClass) throws Exception {
        studentClassRepository.delete(studentClass);
        Clazz clazz = classService.getClassById(studentClass.getIdClass());
        clazz.setSize(studentClassRepository.findStudentClassByIdClass(studentClass.getIdClass()).size());
        classService.updateClass(clazz);
    }
}
