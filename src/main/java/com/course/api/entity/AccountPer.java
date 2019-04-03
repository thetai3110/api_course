package com.course.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_PER")
public class AccountPer {

    @Id
    @Column(name = "id_accountper")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccountPer;

    @Column(name = "id_account")
    private Integer idAccount;

    @Column(name = "id_per")
    private Integer idPer;

    @Basic
    @Column(name = "CREATED_BY", nullable = true)
    private Integer createdBy;

    @Basic
    @Column(name = "MODIFY_BY", nullable = true)
    private Integer modifyBy;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = true)
    private Date createdDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    public AccountPer() {
    }

    public AccountPer(Integer idAccount, Integer idPer, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate) {
        this.idAccount = idAccount;
        this.idPer = idPer;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public Integer getIdAccountPer() {
        return idAccountPer;
    }

    public void setIdAccountPer(Integer idAccountPer) {
        this.idAccountPer = idAccountPer;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
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
}
