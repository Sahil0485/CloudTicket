package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "seatmapping")
public class SeatMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String className;
    String seat_range;
    int basePrice;
    int windowPrice;
    int totalWindow;
}
