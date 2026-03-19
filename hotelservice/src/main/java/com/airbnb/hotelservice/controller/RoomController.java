package com.airbnb.hotelservice.controller;

import com.airbnb.hotelservice.entity.Room;
import com.airbnb.hotelservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Room> getRoomsByHotel(@PathVariable Long hotelId) {
        return roomRepository.findByHotelHotelId(hotelId);
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoom(@PathVariable Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @PutMapping("/rooms/{roomId}/decrease/{count}")
    public void decreaseRooms(@PathVariable Long roomId, @PathVariable Integer count) {

        Room room = roomRepository.findById(roomId).orElseThrow();
        if(room.getAvailableRooms() < count){
            throw new RuntimeException("Rooms not available");
        }

        room.setAvailableRooms(room.getAvailableRooms() - count);

        roomRepository.save(room);
    }

    @PutMapping("/rooms/{roomId}/increase/{count}")
    public void increaseRooms(@PathVariable Long roomId, @PathVariable Integer count) {

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));

        room.setAvailableRooms(room.getAvailableRooms() + count);

        roomRepository.save(room);
    }
}
