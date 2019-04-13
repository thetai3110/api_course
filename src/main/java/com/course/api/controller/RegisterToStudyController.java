package com.course.api.controller;

import com.course.api.dto.StudentClassDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.model.ResponseModel;
import com.course.api.service.ClassService;
import com.course.api.service.RegisterToStudyService;
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
    private RegisterToStudyService registerToStudyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int registerToStudy(@RequestBody StudentClassDTO studentClassDTO){
        if(studentClassDTO == null)
            return 0;
        try {
            ResponseModel model = registerToStudyService.register(studentClassDTO);
            if(model.getMessage().equals("success"))
                return 1;
            else if(model.getMessage().equals("full"))
                return 2;
            else return 3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
