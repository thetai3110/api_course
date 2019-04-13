package com.course.api.service.serviceimpl;

import com.course.api.entity.EducationProgram;
import com.course.api.repository.EducationProgramRepository;
import com.course.api.service.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("educationProgramService")
public class EducationProgramServiceImpl implements EducationProgramService {

    @Autowired
    private EducationProgramRepository educationProgramRepository;

    @Override
    public List<EducationProgram> getAll()  {
        return educationProgramRepository.findAll();
    }

    @Override
    public EducationProgram getEducationProgramById(Integer id) {
        return educationProgramRepository.findEducationProgramByIdEdu(id);
    }

    @Override
    public EducationProgram addEducationProgram(EducationProgram educationProgram) {
        educationProgram.setCreatedDate(new Date());
        educationProgram.setModifyDate(new Date());
        educationProgramRepository.save(educationProgram);
        return educationProgram;
    }

    @Override
    public EducationProgram updateEducationProgram(EducationProgram educationProgram) {
        educationProgram.setModifyDate(new Date());
        educationProgramRepository.save(educationProgram);
        return educationProgram;
    }

    @Override
    public void removeEducationProgram(EducationProgram educationProgram) {
        educationProgramRepository.delete(educationProgram);
    }
}
