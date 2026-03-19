package com.airbnb.hotelservice.controller;

import com.airbnb.hotelservice.entity.Hotel;
import com.airbnb.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/addHotel")
    public ResponseEntity<?> addHotel(@RequestBody Hotel hotel) {
        if (hotel.getRooms() != null) {
            hotel.getRooms().forEach(room -> room.setHotel(hotel));
        }
        Hotel savedHotel = hotelRepository.save(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> findAllHotels(){
        return new ResponseEntity<>(hotelRepository.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/hotels/{hotelId}")
    public Optional<Hotel> findByHotelId(@PathVariable Long hotelId){
        return hotelRepository.findById(hotelId);
    }
}
