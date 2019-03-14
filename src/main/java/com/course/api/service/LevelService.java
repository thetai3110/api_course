package com.course.api.service;

import com.course.api.entity.Level;

import java.util.List;

public interface LevelService {
    List<Level> getAll() throws Exception;
    Level getLevelById(Integer id) throws Exception;
    Level addLevel(Level level) throws Exception;
    Level updateLevel(Level level) throws Exception;
    void removeLevel(Level level) throws Exception;
}
