package com.course.api.controller;

import com.course.api.dto.ClassesDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Lecturers;
import com.course.api.sendemail.Email;
import com.course.api.service.ClassService;
import com.course.api.service.LecturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private LecturersService lecturersService;

    @RequestMapping(value = "/follow-course/{idCourse}", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClassesByCourse(@PathVariable(name = "idCourse") Integer idCourse){
        try {
            List<Clazz> classes = classService.getClassByCourse(idCourse);
            if(classes.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Clazz>>(classes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/follow-course/{idCourse}/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClassesByCourseAndStatus(@PathVariable(name = "idCourse") Integer idCourse, @PathVariable(name = "status") Integer status){
        try {
            List<Clazz> classes = classService.getClassByCourseAndStatus(idCourse, status);
            if(classes.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Clazz>>(classes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClassesByStatus(@PathVariable(name = "status") Integer status){
        try {
            List<Clazz> classes = classService.getClassByStatus(status);
            if(classes.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Clazz>>(classes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/follow-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Clazz> getClassesById(@PathVariable(name = "id") Integer idClass){
        try {
            Clazz classes = classService.getClassById(idClass);
            if(classes==null)
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Clazz>(classes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getAllClass() {
        try {
            List<Clazz> clazzes = classService.getAll();
            if (clazzes.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Clazz>>(clazzes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Clazz> addClass(@RequestBody ClassesDTO classesDTO) {
        try {
            if (classesDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Clazz>(classService.addClass(classesDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Clazz> updateClass(@PathVariable(name = "id") Integer idClazz, @RequestBody ClassesDTO classesDTO) {
        try {
            Clazz curClazz = classService.getClassById(idClazz);
            if (curClazz == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            //clazz.setIdClass(idClazz);
            return new ResponseEntity<Clazz>(classService.updateClass(classesDTO, idClazz), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update1/{id}", method = RequestMethod.POST)
    public ResponseEntity<Clazz> updateClass(@PathVariable(name = "id") Integer idClazz, @RequestBody Clazz clazz) {
        try {
            Clazz curClazz = classService.getClassById(idClazz);
            if (curClazz == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            clazz.setIdClass(idClazz);
            return new ResponseEntity<Clazz>(classService.updateClass(clazz), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteClass(@PathVariable(name = "id") Integer id) {
        try {
            Clazz clazz = classService.getClassById(id);
            if (clazz == null) return false;
            classService.removeClass(clazz);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/teaching-assignment/{idClass}", method = RequestMethod.POST)
    public boolean teachingAssignment(@PathVariable(name = "idClass") Integer idClass,@RequestBody List<Integer> listSend) {
        try {
            if (listSend.isEmpty()) return false;
            for(int i=0;i<listSend.size();i++) {
                Lecturers lecturers = lecturersService.getLecturersById(listSend.get(i));
                Email.sendLecturers("Trung tâm tin học (Hiện đang có lớp phù hợp với bạn)","Đăng ký dạy học",lecturers.getEmail(), classService.getClassById(idClass),listSend.get(i));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/open/{idClass}", method = RequestMethod.GET)
    public boolean openClass(@PathVariable(name = "idClass") Integer idClass) {
        try {
            Clazz clazz = classService.getClassById(idClass);
            if(clazz == null) return false;
            if(classService.openClass(idClass) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/close/{idClass}", method = RequestMethod.GET)
    public boolean closeClass(@PathVariable(name = "idClass") Integer idClass) {
        try {
            Clazz clazz = classService.getClassById(idClass);
            if(clazz == null) return false;
            if(classService.closeClass(idClass) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/cancel/{idClass}", method = RequestMethod.GET)
    public boolean cancelClass(@PathVariable(name = "idClass") Integer idClass) {
        try {
            Clazz clazz = classService.getClassById(idClass);
            if(clazz == null) return false;
            if(classService.cancelClass(idClass) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/finish/{idClass}", method = RequestMethod.GET)
    public boolean finish(@PathVariable(name = "idClass") Integer idClass) {
        try {
            Clazz clazz = classService.getClassById(idClass);
            if(clazz == null) return false;
            if(classService.finish(idClass) == true) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/export/{idClass}/{fileName}", method = RequestMethod.GET)
    public boolean finish(@PathVariable(name = "idClass") Integer idClass, @PathVariable(name = "fileName") String fileName) {
        try {
            Clazz clazz = classService.getClassById(idClass);
            if(clazz == null) return false;
            classService.exportClass(idClass, fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
