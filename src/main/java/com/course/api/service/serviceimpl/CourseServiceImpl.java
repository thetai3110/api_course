package com.course.api.service.serviceimpl;

import com.course.api.entity.Course;
import com.course.api.entity.Level;
import com.course.api.repository.CourseRepository;
import com.course.api.service.CourseService;
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
    public Course addCourse(Course course)  {
        course.setCreatedDate(new Date());
        course.setModifyDate(new Date());
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course ){
        course.setModifyDate(new Date());
        courseRepository.save(course);
        return course;
    }

    @Override
    public void removeCourse(Course course) {
        courseRepository.save(course);
    }
}
