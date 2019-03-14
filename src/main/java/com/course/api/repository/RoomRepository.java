package com.course.api.repository;

import com.course.api.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomByIdRoom(Integer idRoom);
}
