package com.course.api.service.serviceimpl;

import com.course.api.dto.StudentDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Register;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.model.ResponseModel;
import com.course.api.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("registerToStudyService")
public class RegisterToStudyServiceImpl implements RegisterToStudyService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private ClassService classService;

    @Autowired
    private RegisterService registerService;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ResponseModel register(Integer idReg, List<StudentDTO> studentDTOs) {
        ResponseModel model = new ResponseModel();
        try {
            //Thêm học viên mới
            List<Student> students= studentService.addMultiStudent(studentDTOs);
            List<StudentClass> studentClasses = new ArrayList<>();
            Register register = registerService.getRegisterById(idReg);
            if(!students.isEmpty()){
                //Thêm vào lớp
                for (Student student:
                     students) {
                    StudentClass studentClass = new StudentClass();
                    studentClass.setIdClass(register.getIdClass());
                    studentClass.setIdStudent(student.getIdStudent());
                    studentClass.setIsFee(register.getIsFee());
                    studentClasses.add(studentClass);
                }
                studentClassService.addMultiStudentClass(studentClasses);
            }
            //Update sĩ số
            Clazz clazz = classService.getClassById(register.getIdClass());
            clazz.setSize(studentClassService.getStudentByClass(register.getIdClass()).size());
            classService.updateClass(clazz);
            //Đã xác thực
            register.setStatus(1);
            registerService.updateRegister(register);
            model.setMessage("success");
            model.setData(students);
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            model.setMessage("fail");
            return model;
        }
    }
}
