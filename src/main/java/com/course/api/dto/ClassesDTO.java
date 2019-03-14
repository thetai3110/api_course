package com.course.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassesDTO {

    @Id
    private String id;
    private int size;
    private int minsize;
    private int maxsize;
    private int status;

    public ClassesDTO() {
    }

    public ClassesDTO(String id, int size, int minsize, int maxsize, int status) {
        this.id = id;
        this.size = size;
        this.minsize = minsize;
        this.maxsize = maxsize;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
