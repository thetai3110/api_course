package com.course.api.service.serviceimpl;

import com.course.api.dto.StudentDTO;
import com.course.api.entity.Student;
import com.course.api.repository.AccountRepositoty;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Autowired
    private AccountRepositoty accountRepositoty;

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
    public Student addStudent(StudentDTO studentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<StudentDTO, Student>() {
            @Override
            protected void configure() {
                skip().setIdStudent(null);
            }
        });
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setAccountStu(accountRepositoty.findAccountByIdAccount(studentDTO.getIdAccount()));
        student.setCreatedDate(new Date());
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public Student updateStudent(StudentDTO studentDTO, Integer idStudent) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<StudentDTO, Student>() {
            @Override
            protected void configure() {
                skip().setIdStudent(null);
            }
        });
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setIdStudent(idStudent);
        student.setAccountStu(accountRepositoty.findAccountByIdAccount(studentDTO.getIdAccount()));
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public void removeStudent(Student student) {
        studentRepositoty.delete(student);
    }
}
