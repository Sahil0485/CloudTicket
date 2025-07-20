package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "aircrafts")
public class AirCraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    int modelNumber;
    String manufacturer;
    String modelName;
    int totalFlight;
    LocalDate buildDate;

    @ManyToOne
    Airline airline;
    int capacity;
}
