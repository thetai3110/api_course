package com.course.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class InfoStudentDTO {

    //Student-Class
    @Id
    private Integer idClass;
    private Integer idStudent;
    private Integer idStudentclass;
    private Integer isfee;
    //Class
    private Integer idRoom;
    private Integer idLecturers;
    private Integer idCourse;
    private String className;
    private int size;
    private int minsize;
    private int maxsize;
    private int statusClass;
    //Course
    private Integer idLevel;
    private Integer idEdu;
    private String course;
    private String duration;
    private Date dayStart;
    private int fee;
    private String space;
    private String conditions;
    private String describes;
    private int statusCourse;
    private String image;
    //Level
    private String levelCourse;
    //Student
    private String studentName;
    private String cmnd;
    private Date studentDate;
    private Integer sex;
    private String address;
    private String email;
    private String phone;
    private String job;

    public InfoStudentDTO() {
    }

    public InfoStudentDTO(Integer idClass, Integer idStudent, Integer idStudentclass, Integer isfee, Integer idRoom, Integer idLecturers, Integer idCourse, String className, int size, int minsize, int maxsize, int statusClass, Integer idLevel, Integer idEdu, String course, String duration, Date dayStart, int fee, String space, String conditions, String describes, int statusCourse, String image, String levelCourse, String studentName, String cmnd, Date studentDate, Integer sex, String address, String email, String phone, String job) {
        this.idClass = idClass;
        this.idStudent = idStudent;
        this.idStudentclass = idStudentclass;
        this.isfee = isfee;
        this.idRoom = idRoom;
        this.idLecturers = idLecturers;
        this.idCourse = idCourse;
        this.className = className;
        this.size = size;
        this.minsize = minsize;
        this.maxsize = maxsize;
        this.statusClass = statusClass;
        this.idLevel = idLevel;
        this.idEdu = idEdu;
        this.course = course;
        this.duration = duration;
        this.dayStart = dayStart;
        this.fee = fee;
        this.space = space;
        this.conditions = conditions;
        this.describes = describes;
        this.statusCourse = statusCourse;
        this.image = image;
        this.levelCourse = levelCourse;
        this.studentName = studentName;
        this.cmnd = cmnd;
        this.studentDate = studentDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.job = job;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdStudentclass() {
        return idStudentclass;
    }

    public void setIdStudentclass(Integer idStudentclass) {
        this.idStudentclass = idStudentclass;
    }

    public Integer getIsfee() {
        return isfee;
    }

    public void setIsfee(Integer isfee) {
        this.isfee = isfee;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdLecturers() {
        return idLecturers;
    }

    public void setIdLecturers(Integer idLecturers) {
        this.idLecturers = idLecturers;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMinsize() {
        return minsize;
    }

    public void setMinsize(int minsize) {
        this.minsize = minsize;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getStatusClass() {
        return statusClass;
    }

    public void setStatusClass(int statusClass) {
        this.statusClass = statusClass;
    }

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public Integer getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(Integer idEdu) {
        this.idEdu = idEdu;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getStatusCourse() {
        return statusCourse;
    }

    public void setStatusCourse(int statusCourse) {
        this.statusCourse = statusCourse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLevelCourse() {
        return levelCourse;
    }

    public void setLevelCourse(String levelCourse) {
        this.levelCourse = levelCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getStudentDate() {
        return studentDate;
    }

    public void setStudentDate(Date studentDate) {
        this.studentDate = studentDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
