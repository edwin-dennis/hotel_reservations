package com.hotel.reservations.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ReservationDto implements Serializable {

    private Long id;

    @NotNull(message = "The name is required")
    private String clientFullName;
    @NotNull(message = "The room number is required")
    private int roomNumber;
    @NotNull(message = "You need to have reservation dates")
    private List<Date> reservationDates;


}



