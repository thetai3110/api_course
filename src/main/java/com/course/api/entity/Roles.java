package com.course.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles", nullable = false)
    private Integer idRoles;

    @Basic
    @Column(name = "name_roles", nullable = true, length = 25)
    private String nameRoles;

    @Basic
    @Column(name = "describes", nullable = true, length = 25)
    private String describes;

    public Roles() {
    }

    public Roles(String nameRoles, String describes) {
        this.nameRoles = nameRoles;
        this.describes = describes;
    }

    public Integer getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public String getNameRoles() {
        return nameRoles;
    }

    public void setNameRoles(String nameRoles) {
        this.nameRoles = nameRoles;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
