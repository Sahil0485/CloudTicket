package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "flightbookedseats")
public class FlightSeatBooked {
    // this table is strictly going to use for non-connecting flights

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    @ManyToOne
    Flight flight;

    @ManyToOne
    AppUser bookedBy;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
