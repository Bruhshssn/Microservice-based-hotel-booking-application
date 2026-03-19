package com.airbnb.hotelservice.repository;

import com.airbnb.hotelservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotelHotelId(Long hotelId);
}
