package com.course.api.service.serviceimpl;

import com.course.api.entity.StudentClass;
import com.course.api.repository.StudentClassRepository;
import com.course.api.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("studentClassService")
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Override
    public List<StudentClass> getAll() {
        return studentClassRepository.findAll();
    }

    @Override
    public StudentClass getStudentClassById(Integer idStudentClass) {
        return studentClassRepository.findStudentClassByIdStudentClass(idStudentClass);
    }

    @Override
    public StudentClass getStudentClassByStudentAndClass(Integer idStudent, Integer idClass) {
        return studentClassRepository.findStudentClassByIdStudentAndIdClass(idStudent,idClass);
    }

    @Override
    public StudentClass addStudentClass(StudentClass studentClass) {
        studentClass.setCreatedDate(new Date());
        studentClass.setModifyDate(new Date());
        studentClassRepository.save(studentClass);
        return studentClass;
    }

    @Override
    public StudentClass updateStudentClass(StudentClass studentClass) {
        studentClass.setModifyDate(new Date());
        studentClassRepository.save(studentClass);
        return studentClass;
    }

    @Override
    public void removeStudentClass(StudentClass studentClass)  {
        studentClassRepository.delete(studentClass);
    }
}
