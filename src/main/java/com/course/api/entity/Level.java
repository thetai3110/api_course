package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LEVELCOURSE")
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_level", nullable = false)
    private Integer idLevel;

    @Basic
    @Column(name = "level_course", nullable = true, length = 30)
    private String level;

    public Level() {
    }

    public Level(String level) {
        this.level = level;
    }

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
