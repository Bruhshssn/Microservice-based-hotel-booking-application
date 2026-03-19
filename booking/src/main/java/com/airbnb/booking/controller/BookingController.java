package com.airbnb.booking.controller;

import com.airbnb.booking.dto.BookingRequest;
import com.airbnb.booking.entity.UserBooking;
import com.airbnb.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<UserBooking> addBooking(@RequestBody BookingRequest bookingRequest) {
        UserBooking  booking = bookingService.createBooking(bookingRequest);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking cancelled successfully");
    }

}
