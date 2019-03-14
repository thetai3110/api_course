package com.course.api.service.serviceimpl;

import com.course.api.entity.Student;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Override
    public List<Student> getAll() {
        return studentRepositoty.findAll();
    }

    @Override
    public Student getStudentById(Integer idStu) throws Exception {
        return studentRepositoty.findStudentByIdStudent(idStu);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepositoty.findStudentByStudentName(name);
    }

    @Override
    public Student getStudentByCMND(String CMND) {
        return studentRepositoty.findStudentByCmnd(CMND);
    }

    @Override
    public Student getStudentByEmail(String email) throws Exception {
        return studentRepositoty.findStudentByEmail(email);
    }

    @Override
    public Student addStudent(Student student) {
        student.setCreatedDate(new Date());
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public void removeStudent(Student student) {
        studentRepositoty.delete(student);
    }
}
