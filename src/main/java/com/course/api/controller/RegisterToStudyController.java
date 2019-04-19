package com.course.api.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping(value = "/register-to-study")
public class RegisterToStudyController {

    @Autowired
    private RegisterToStudyService registerToStudyService;

    @RequestMapping(value = "/{idReg}", method = RequestMethod.POST)
    public int registerToStudy(@PathVariable(name = "idReg") Integer idReg ,@RequestBody List<StudentDTO> studentDTOs){
        if(studentDTOs.isEmpty())
            return 0;
        try {
            ResponseModel model = registerToStudyService.register(idReg, studentDTOs);
            if(model.getMessage().equals("success"))
                return 1;
            else if(model.getMessage().equals("fail"))
                return 2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
