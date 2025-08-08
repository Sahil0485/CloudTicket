package com.fbs.central_api.controllers;

import com.fbs.central_api.dto.AirlineRegistratioDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.service.AirlineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j // it used for printing log to identify errors in code
@RestController
@RequestMapping("/api/v1/central/airline")
public class AirlineController {

    AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService){
        this.airlineService = airlineService;
    }

    @PostMapping("/register")
    public ResponseEntity registerAirline(@RequestBody AirlineRegistratioDto airlineDetails){
        log.info("airlineRegistration method got called with requestBody: " + airlineDetails.toString());
        log.info("calling airlineService -> registerAirline method");

        Airline airline = airlineService.registerAirline(airlineDetails);
        return new ResponseEntity(airline, HttpStatus.CREATED);
    }

    @GetMapping("/request/accept/{airlineId}")
    public void acceptAirlineRequest(@PathVariable UUID airlineId){
        log.info("airlineId: " + airlineId.toString());

    }
}
