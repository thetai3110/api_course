package com.course.api.service.serviceimpl;

import com.course.api.dto.CourseDTO;
import com.course.api.entity.Course;
import com.course.api.entity.Level;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.LevelRepositoty;
import com.course.api.service.CourseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LevelRepositoty levelRepositoty;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCourseByLevel(Integer idLevel) {
        String query = "SELECT * FROM COURSE WHERE id_level =:idLevel";
        return entityManager.createNativeQuery(query,Course.class).setParameter("idLevel",idLevel).getResultList();
    }

    @Override
    public Course getCourseById(Integer idCouese) {
        return courseRepository.findCourseByIdCourse(idCouese);
    }

    @Override
    public Course addCourse(CourseDTO courseDTO)  {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CourseDTO, Course>() {
            @Override
            protected void configure() {
                skip().setIdCourse(null);
            }
        });
        Course course = modelMapper.map(courseDTO, Course.class);
        course.setLevel(levelRepositoty.findAllByIdLevel(courseDTO.getIdLevel()));
        course.setCreatedDate(new Date());
        course.setModifyDate(new Date());
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course updateCourse(CourseDTO courseDTO, Integer idCourse){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CourseDTO, Course>() {
            @Override
            protected void configure() {
                skip().setIdCourse(null);
            }
        });
        Course course = modelMapper.map(courseDTO, Course.class);
        course.setIdCourse(idCourse);
        course.setLevel(levelRepositoty.findAllByIdLevel(courseDTO.getIdLevel()));
        course.setModifyDate(new Date());
        courseRepository.save(course);
        return course;
    }

    @Override
    public void removeCourse(Course course) {
        courseRepository.delete(course);
    }
}
