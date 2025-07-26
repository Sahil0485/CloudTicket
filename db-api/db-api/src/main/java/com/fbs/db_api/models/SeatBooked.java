package com.fbs.db_api.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "seatbooked")
public class SeatBooked {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String Passenger;
    boolean above18;
    int seatNumber;
}
