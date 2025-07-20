package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    @ManyToOne
    Airline airline;

    @ManyToOne
    AirCraft airCraft;

    String sourceAirport;
    String destinationAirport;
    String flightType;
    int totalTime;
    LocalDateTime boardingTime;
    int boardingMinutes;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    boolean isConnecting;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
