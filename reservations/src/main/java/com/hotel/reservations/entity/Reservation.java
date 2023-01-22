package com.hotel.reservations.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
public class Reservation implements Serializable {

    public Reservation(){}
    public Reservation(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String clientFullName;
    private int roomNumber;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Date> reservationDates;

}



