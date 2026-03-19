package com.airbnb.hotelservice.repository;

import com.airbnb.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByHotelId(Long hotelId);

}
