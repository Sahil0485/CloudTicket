package com.fbs.db_api.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seatbooked")
public class SeatBooked {

    String Passenger;
    boolean above18;
    int seatNumber;
}
