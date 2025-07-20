package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    @ManyToOne
    Flight flight;

    @ManyToMany
    List<SubFlight> subFlights;

    @ManyToOne
    AppUser bookedBy;

    int totalAmount;
    String passengerName;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
