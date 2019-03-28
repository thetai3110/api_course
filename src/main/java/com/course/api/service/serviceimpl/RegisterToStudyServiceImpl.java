package com.course.api.service.serviceimpl;

import com.course.api.dto.StudentClassDTO;
import com.course.api.dto.StudentDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.model.ResponseModel;
import com.course.api.service.ClassService;
import com.course.api.service.RegisterToStudyService;
import com.course.api.service.StudentClassService;
import com.course.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerToStudyService")
public class RegisterToStudyServiceImpl implements RegisterToStudyService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private ClassService classService;

    @Override
    public ResponseModel register(StudentClassDTO studentClassDTO) {
        ResponseModel model = new ResponseModel();
        ModelMapper modelMapper = new ModelMapper();
        try {
            //Thêm học viên mới
            Student student = new Student();
            if(studentService.getStudentByCMND(studentClassDTO.getCmnd())!= null){
                student = studentService.getStudentByCMND(studentClassDTO.getCmnd());
                if(studentClassService.getStudentClassByStudentAndClass(student.getIdStudent(), studentClassDTO.getIdClass())!= null){
                    model.setMessage("duplicate");
                    return model;
                }
            }
            else{
                modelMapper.addMappings(new PropertyMap<StudentClassDTO, StudentDTO>() {
                    @Override
                    protected void configure() {
                        skip().setIdAccount(null);
                    }
                });
//                student.setCmnd(studentClassDTO.getCmnd());
//                student.setJob(studentClassDTO.getJob());
//                student.setStudentDate(studentClassDTO.getDate());
//                student.setSex(studentClassDTO.getSex());
//                student.setAddress(studentClassDTO.getAddress());
//                student.setEmail(studentClassDTO.getEmail());
//                student.setPhone(studentClassDTO.getPhone());
//                student.setStudentName(studentClassDTO.getName());
                StudentDTO studentDTO = modelMapper.map(studentClassDTO, StudentDTO.class);
                studentService.addStudent(studentDTO);
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
            //classService.updateClass(clazz);
            model.setMessage("success");
            model.setData(studentClassDTO);
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            model.setMessage("fail");
            return model;
        }
    }
}
