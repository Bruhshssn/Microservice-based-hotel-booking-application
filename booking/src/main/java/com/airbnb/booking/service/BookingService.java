package com.airbnb.booking.service;

import com.airbnb.booking.dto.BookingRequest;
import com.airbnb.booking.dto.RoomDTO;
import com.airbnb.booking.entity.UserBooking;
import com.airbnb.booking.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelClient hotelClient;

    @Transactional
    public UserBooking createBooking(BookingRequest bookingrequest) {

        RoomDTO room = hotelClient.getRoomById(bookingrequest.getRoomId());

        if (room.getAvailableRooms() < bookingrequest.getBookRooms()) {
            throw new RuntimeException("Not enough rooms available");
        }
        hotelClient.decreaseRooms(
                bookingrequest.getRoomId(),
                bookingrequest.getBookRooms()
        );
        UserBooking booking = new UserBooking();

        booking.setHotelId(bookingrequest.getHotelId());
        booking.setRoomId(bookingrequest.getRoomId());
        booking.setUserId(bookingrequest.getUserId());
        booking.setCheckInDate(bookingrequest.getCheckInDate());
        booking.setCheckOutDate(bookingrequest.getCheckOutDate());
        booking.setBookRooms(bookingrequest.getBookRooms());
        booking.setBookingStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    @Transactional
    public void deleteBooking(Long bookingId) {
        UserBooking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        hotelClient.increaseRooms(
                booking.getRoomId(),
                booking.getBookRooms()
        );
        bookingRepository.delete(booking);
    }
}
