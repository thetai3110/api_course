package com.course.api.service.serviceimpl;

import com.course.api.entity.Room;
import com.course.api.repository.RoomRepository;
import com.course.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Integer idRoom) {
        return roomRepository.findRoomByIdRoom(idRoom);
    }

    @Override
    public Room addRoom(Room room) {
        room.setCreatedDate(new Date());
        room.setModifyDate(new Date());
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room updateRoom(Room room) {
        room.setModifyDate(new Date());
        roomRepository.save(room);
        return room;
    }

    @Override
    public void removeRoom(Room room) {
        roomRepository.delete(room);
    }
}
