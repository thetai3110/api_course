package com.course.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLES")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_roles", nullable = false)
    private Integer idUserRoles;

    @Basic
    @Column(name = "id_roles", nullable = true, length = 25)
    private Integer idRoles;

    @Basic
    @Column(name = "id_employee", nullable = true, length = 25)
    private Integer idEmployee;

    public UserRoles() {
    }

    public UserRoles(Integer idRoles, Integer idEmployee) {
        this.idRoles = idRoles;
        this.idEmployee = idEmployee;
    }

    public Integer getIdUserRoles() {
        return idUserRoles;
    }

    public void setIdUserRoles(Integer idUserRoles) {
        this.idUserRoles = idUserRoles;
    }

    public Integer getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
}
