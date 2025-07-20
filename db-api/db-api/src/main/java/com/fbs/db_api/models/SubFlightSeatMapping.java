package com.fbs.db_api.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "subflightseatmapping")
public class SubFlightSeatMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID Id;

    @ManyToOne
    SubFlight flight;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
