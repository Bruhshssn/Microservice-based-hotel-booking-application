package com.airbnb.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Long roomId;
    private String roomType;
    private Integer roomPrice;
    private Integer totalRooms;
    private Integer availableRooms;

}
