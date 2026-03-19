package com.airbnb.booking.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private Double rating;
}
