package com.fbs.central_api.dto;

import lombok.Data;

@Data
public class AirlineRegistratioDto {

    String website;
    String airlineName;
    String companyName;
    int employees;
    int totalFlights;
    String email;
    String password;
    Long contactNumber;
}
