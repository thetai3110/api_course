package com.course.api.controller;

import com.course.api.dto.StudentClassDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.service.ClassService;
import com.course.api.service.StudentClassService;
import com.course.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping(value = "/register-to-study")
public class RegisterToStudyController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int registerToStudy(@RequestBody StudentClassDTO studentClassDTO){
        if(studentClassDTO == null)
            return 0;
        try {
            //Thêm học viên mới
            Student student = new Student();
            if(studentService.getStudentByCMND(studentClassDTO.getCmnd())!= null){
                student = studentService.getStudentByCMND(studentClassDTO.getCmnd());
                if(studentClassService.getStudentClassByStudentAndClass(student.getIdStudent(), studentClassDTO.getIdClass())!= null)
                    return 2;
            }
            else{
                student.setCmnd(studentClassDTO.getCmnd());
                student.setJob(studentClassDTO.getJob());
                student.setStudentDate(studentClassDTO.getDate());
                student.setSex(studentClassDTO.getSex());
                student.setAddress(studentClassDTO.getAddress());
                student.setEmail(studentClassDTO.getEmail());
                student.setPhone(studentClassDTO.getPhone());
                student.setStudentName(studentClassDTO.getName());
                studentService.addStudent(student);
            }
            //Thêm vào lớp
            StudentClass studentClass = new StudentClass();
            studentClass.setIdClass(studentClassDTO.getIdClass());
            studentClass.setIdStudent(student.getIdStudent());
            studentClass.setIsFee(0);
            studentClassService.addStudentClass(studentClass);
            //Cập nhật sĩ số
            Clazz clazz = classService.getClassById(studentClassDTO.getIdClass());
            clazz.setSize(clazz.getSize() + 1);
            classService.updateClass(clazz);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
