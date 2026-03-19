package com.airbnb.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {

    @NotNull(message = "Required")
    private Long userId;
    @NotNull(message = "Required")
    private Long hotelId;
    @NotNull(message = "Required")
    private Long roomId;
    @NotNull(message = "Required")
    private LocalDate checkInDate;
    @NotNull(message = "Required")
    private LocalDate checkOutDate;
    @NotNull(message = "Required")
    private Integer bookRooms;
}
