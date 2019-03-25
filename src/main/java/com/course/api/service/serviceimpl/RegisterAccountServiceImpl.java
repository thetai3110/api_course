package com.course.api.service.serviceimpl;

import com.course.api.dto.StudentDTO;
import com.course.api.dto.UserDTO;
import com.course.api.entity.Account;
import com.course.api.entity.Student;
import com.course.api.model.ResponseModel;
import com.course.api.service.AccountService;
import com.course.api.service.RegisterAccountService;
import com.course.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerAccountService")
public class RegisterAccountServiceImpl implements RegisterAccountService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;

    @Override
    public ResponseModel register(UserDTO userDTO) {
        ResponseModel model = new ResponseModel();
        Account newAcc = new Account();
        newAcc.setUsername(userDTO.getUsername());
        newAcc.setPass(userDTO.getPass());
        //Người dùng mới
//        Student newStu = new Student();
//        newStu.setAccountStu(newAcc);
//        newStu.setStudentName(userDTO.getName());
//        newStu.setCmnd(userDTO.getCmnd());
//        newStu.setStudentDate(userDTO.getDate());
//        newStu.setSex(Integer.parseInt(userDTO.getSex()));
//        newStu.setAddress(userDTO.getAddress());
//        newStu.setEmail(userDTO.getEmail());
//        newStu.setPhone(userDTO.getPhone());
//        newStu.setJob(userDTO.getJob());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UserDTO, StudentDTO>() {
            @Override
            protected void configure() {
                skip().setIdAccount(null);
            }
        });
        StudentDTO studentDTO = modelMapper.map(userDTO, StudentDTO.class);
        try {
            accountService.addAccount(newAcc);
            studentService.addStudent(studentDTO);
            model.setData(userDTO);
            model.setMessage("success");
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            model.setMessage("fail");
            return model;
        }
    }
}
