package com.course.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLES_DETAIL")
public class RolesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles_detail", nullable = false)
    private Integer idRolesDetail;

    @Basic
    @Column(name = "id_roles", nullable = true, length = 25)
    private Integer idRoles;

    @Basic
    @Column(name = "action_name", nullable = true, length = 25)
    private String actionName;

    @Basic
    @Column(name = "action_code", nullable = true, length = 25)
    private String actionCode;

    @Basic
    @Column(name = "check_action", nullable = true, length = 25)
    private Integer checkAction;

    public RolesDetail() {
    }

    public RolesDetail(Integer idRoles, String actionName, String actionCode, Integer checkAction) {
        this.idRoles = idRoles;
        this.actionName = actionName;
        this.actionCode = actionCode;
        this.checkAction = checkAction;
    }

    public Integer getIdRolesDetail() {
        return idRolesDetail;
    }

    public void setIdRolesDetail(Integer idRolesDetail) {
        this.idRolesDetail = idRolesDetail;
    }

    public Integer getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public Integer getCheckAction() {
        return checkAction;
    }

    public void setCheckAction(Integer checkAction) {
        this.checkAction = checkAction;
    }
}
