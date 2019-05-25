package com.course.api.controller;

import com.course.api.entity.Room;
import com.course.api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getAllRoom() {
        try {
            List<Room> rooms = roomService.getAll();
            if (rooms.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Room> getAllRoom(@PathVariable(name = "id") Integer id) {
        try {
            Room room = roomService.getRoomById(id);
            if (room == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        try {
            if (room == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<Room>(roomService.addRoom(room), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Room> updateRoom(@PathVariable(name = "id") Integer idRoom, @RequestBody Room room) {
        try {
            Room curRoom = roomService.getRoomById(idRoom);
            if (curRoom == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            room.setIdRoom(idRoom);
            room.setCreatedDate(curRoom.getCreatedDate());
            return new ResponseEntity<Room>(roomService.updateRoom(room), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteRoom(@PathVariable(name = "id") Integer id) {
        try {
            Room curRoom = roomService.getRoomById(id);
            if (curRoom == null) return false;
            roomService.removeRoom(curRoom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
