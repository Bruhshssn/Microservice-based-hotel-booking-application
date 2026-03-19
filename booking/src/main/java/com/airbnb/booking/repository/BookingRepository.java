package com.airbnb.booking.repository;

import com.airbnb.booking.entity.UserBooking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<UserBooking, Long> {

}
