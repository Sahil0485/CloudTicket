package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "flightseatmapping")
public class FlightSearMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    @ManyToOne
    Flight flight;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
