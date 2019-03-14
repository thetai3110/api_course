package com.course.api.service.serviceimpl;

import com.course.api.entity.Level;
import com.course.api.repository.LevelRepositoty;
import com.course.api.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("levelService")
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepositoty levelRepositoty;

    @Override
    public List<Level> getAll() {
        return levelRepositoty.findAll();
    }

    @Override
    public Level getLevelById(Integer id) {
        return levelRepositoty.findAllByIdLevel(id);
    }

    @Override
    public Level addLevel(Level level) {
        level.setCreatedDate(new Date());
        level.setModifyDate(new Date());
        levelRepositoty.save(level);
        return level;
    }

    @Override
    public Level updateLevel(Level level) {
        level.setModifyDate(new Date());
        levelRepositoty.save(level);
        return level;
    }

    @Override
    public void removeLevel(Level level) {
        levelRepositoty.delete(level);
    }
}
