package com.fbs.notification_api.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Airline {

    UUID id;
    String website;
    String airlineName;
    String companyName;
    int employees;
    int totalFlights;
    AppUser admin;
    String Status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
