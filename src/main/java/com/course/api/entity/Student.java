package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Integer idStudent;

    @Basic
    @Column(name = "student_name", nullable = true, length = 30)
    private String studentName;

    @Basic
    @Column(name = "job", nullable = true, length = 30)
    private String job;

    @Basic
    @Column(name = "CMND", nullable = true, length = 15)
    private String cmnd;

    @Basic
    @Column(name = "student_date", nullable = true)
    private String studentDate;

    @Basic
    @Column(name = "sex", nullable = true)
    private int sex;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Basic
    @Column(name = "phone", nullable = false, length = 11)
    private String phone;

    @Basic
    @Column(name = "image", nullable = true, length = 30)
    private String image;

    @Basic
    @Column(name = "num_of_register", nullable = true)
    private int numOfRegister;

    @Basic
    @Column(name = "CREATED_BY", nullable = true, length = 8)
    private Integer createdBy;

    @Basic
    @Column(name = "MODIFY_BY", nullable = true)
    private Integer modifyBy;

    @Basic
    @Column(name = "CREATED_DATE", nullable = true, length = 8)
    private Date createdDate;

    @Basic
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account accountStu;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private List<StudentClass> studentClasses;

    public Student() {
    }

    public Student(String studentName, String job, String cmnd, String studentDate, int sex, String address, String email, String phone, String image, int numOfRegister, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Account accountStu, List<StudentClass> studentClasses) {
        this.studentName = studentName;
        this.job = job;
        this.cmnd = cmnd;
        this.studentDate = studentDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.numOfRegister = numOfRegister;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.accountStu = accountStu;
        this.studentClasses = studentClasses;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getStudentDate() {
        return studentDate;
    }

    public void setStudentDate(String studentDate) {
        this.studentDate = studentDate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumOfRegister() {
        return numOfRegister;
    }

    public void setNumOfRegister(int numOfRegister) {
        this.numOfRegister = numOfRegister;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Account getAccountStu() {
        return accountStu;
    }

    public void setAccountStu(Account accountStu) {
        this.accountStu = accountStu;
    }

    public List<StudentClass> getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(List<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }
}
