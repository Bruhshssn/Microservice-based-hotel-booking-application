package com.airbnb.booking.service;

import com.airbnb.booking.dto.HotelDTO;
import com.airbnb.booking.dto.RoomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelClient {

    @GetMapping("/api/hotel/hotels/{hotelId}")
    HotelDTO getHotelById(@PathVariable Long hotelId);

    @GetMapping("/api/room/rooms/{roomId}")
    RoomDTO getRoomById(@PathVariable("roomId") Long roomId);

    @PutMapping("/api/room/rooms/{roomId}/decrease/{count}")
    void decreaseRooms(@PathVariable Long roomId, @PathVariable Integer count);

    @PutMapping("/api/room/rooms/{roomId}/increase/{count}")
    void increaseRooms(@PathVariable Long roomId, @PathVariable Integer count);
}
