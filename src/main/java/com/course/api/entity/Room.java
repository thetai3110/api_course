package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ROOM")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room", nullable = false)
    private Integer idRoom;

    @Basic
    @Column(name = "roomName", nullable = false, length = 30)
    private String roomName;

    @Basic
    @Column(name = "size", nullable = false)
    private int size;

    @Basic
    @Column(name = "status_room", nullable = false, length = 1)
    private int status;

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

    public Room() {
    }

    public Room(String roomName, int size, int status, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate) {
        this.roomName = roomName;
        this.size = size;
        this.status = status;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
