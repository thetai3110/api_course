package com.course.api.service;

import com.course.api.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll() throws Exception;
    Room getRoomById(Integer idRoom) throws Exception;
    Room addRoom(Room room) throws Exception;
    Room updateRoom(Room room) throws Exception;
    void removeRoom(Room room) throws Exception;
}
