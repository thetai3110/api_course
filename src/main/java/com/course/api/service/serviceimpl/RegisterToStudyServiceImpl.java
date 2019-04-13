package com.course.api.service.serviceimpl;

import com.course.api.dto.ClassesDTO;
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

import javax.transaction.Transactional;

@Service("registerToStudyService")
public class RegisterToStudyServiceImpl implements RegisterToStudyService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private ClassService classService;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ResponseModel register(StudentClassDTO studentClassDTO) {
        ResponseModel model = new ResponseModel();
        ModelMapper modelMapper = new ModelMapper();
        try {
            if(studentClassDTO.getIsLogin() == 1){
                if(studentClassService.getStudentClassByStudentAndClass(studentClassDTO.getIdStudent(), studentClassDTO.getIdClass()) == null) {
                    Clazz clazz = classService.getClassById(studentClassDTO.getIdClass());
                    if(clazz.getSize() == clazz.getMaxSize()){
                        model.setMessage("full");
                        return model;
                    }else {
                        //Thêm vào lớp
                        StudentClass studentClass = new StudentClass();
                        studentClass.setIdClass(studentClassDTO.getIdClass());
                        studentClass.setIdStudent(studentClassDTO.getIdStudent());
                        studentClass.setIsFee(0);
                        studentClassService.addStudentClass(studentClass);
                        //Update sĩ số
                        clazz.setSize(studentClassService.getStudentByClass(studentClassDTO.getIdClass()).size());
                        classService.updateClass(clazz);
                        model.setMessage("success");
                        model.setData(studentClassDTO);
                        return model;
                    }
                }else{
                    model.setMessage("duplicate");
                    return model;
                }
            }else{
                //Thêm học viên mới
                Student student = new Student();
                modelMapper.addMappings(new PropertyMap<StudentClassDTO, StudentDTO>() {
                    @Override
                    protected void configure() {
                        skip().setIdAccount(null);
                    }
                });
                StudentDTO studentDTO = modelMapper.map(studentClassDTO, StudentDTO.class);
                student = studentService.addStudent(studentDTO);
                //Thêm vào lớp
                StudentClass studentClass = new StudentClass();
                studentClass.setIdClass(studentClassDTO.getIdClass());
                studentClass.setIdStudent(student.getIdStudent());
                studentClass.setIsFee(0);
                studentClassService.addStudentClass(studentClass);
                //Update sĩ số
                Clazz clazz = classService.getClassById(studentClassDTO.getIdClass());
                clazz.setSize(studentClassService.getStudentByClass(studentClassDTO.getIdClass()).size());
                classService.updateClass(clazz);
                model.setMessage("success");
                model.setData(studentClassDTO);
                return model;
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.setMessage("fail");
            return model;
        }
    }
}
