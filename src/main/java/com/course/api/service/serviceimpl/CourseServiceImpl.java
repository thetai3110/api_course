package com.course.api.service.serviceimpl;

import com.course.api.dto.CourseDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Course;
import com.course.api.entity.Lesson;
import com.course.api.entity.Level;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.EducationProgramRepository;
import com.course.api.repository.LevelRepositoty;
import com.course.api.service.ClassService;
import com.course.api.service.CourseService;
import com.course.api.service.LessonService;
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

    @Autowired
    private EducationProgramRepository educationProgramRepository;

    @Autowired
    private ClassService classService;

    @Autowired
    private LessonService lessonService;

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
    public List<Course> getCourseByStatus(Integer status) {
        return courseRepository.findCourseByStatus(status);
    }

    @Override
    public List<Course> getCourseByEducation(Integer idEdu) {
        String query = "SELECT * FROM COURSE WHERE id_edu =:idEdu";
        return entityManager.createNativeQuery(query,Course.class).setParameter("idEdu",idEdu).getResultList();
    }

    @Override
    public List<Course> getCourseByEducationAndStastus(Integer idEdu, Integer status) {
        String query = "SELECT * FROM COURSE WHERE id_edu =:idEdu and status_course =:status";
        return entityManager.createNativeQuery(query,Course.class).setParameter("idEdu",idEdu).setParameter("status", status).getResultList();
    }

    @Override
    public List<Course> getCourseByEducationAndStastusAndLevel(Integer idEdu, Integer status, Integer idLevel) {
        String query = "SELECT * FROM COURSE WHERE id_edu =:idEdu and id_level =:idLevel and status_course =:status";
        return entityManager.createNativeQuery(query,Course.class).setParameter("idEdu",idEdu).setParameter("idLevel",idLevel).setParameter("status", status).getResultList();
    }

    @Override
    public List<Course> getCourseByLevelAndEducation(Integer idLevel, Integer idEdu) {
        String query = "SELECT * FROM COURSE WHERE id_edu =:idEdu and id_level =:idLevel";
        return entityManager.createNativeQuery(query,Course.class).setParameter("idEdu",idEdu).setParameter("idLevel",idLevel).getResultList();
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
        course.setEducationProgram(educationProgramRepository.findEducationProgramByIdEdu(courseDTO.getIdEdu()));
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
        course.setEducationProgram(educationProgramRepository.findEducationProgramByIdEdu(courseDTO.getIdEdu()));
        course.setModifyDate(new Date());
        courseRepository.save(course);
        return course;
    }

    @Override
    public void removeCourse(Course course) throws Exception {
        if(!classService.getClassByCourse(course.getIdCourse()).isEmpty()){
            for (Clazz cl:
                    classService.getClassByCourse(course.getIdCourse())) {
                classService.removeClass(cl);
            }
        }
        if(!lessonService.getByCourse(course.getIdCourse()).isEmpty()){
            for (Lesson lesson:
                    lessonService.getByCourse(course.getIdCourse())) {
                lessonService.removeLesson(lesson);
            }
        }
        courseRepository.delete(course);
    }
}
