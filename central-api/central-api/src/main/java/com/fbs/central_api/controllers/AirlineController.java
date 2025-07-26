package com.fbs.central_api.controllers;

import com.fbs.central_api.dto.AirlineRegistratioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // it used for printing log to identify errors in code
@RestController
@RequestMapping("/api/v1/central/airline")
public class AirlineController {

    @PostMapping("/register")
    public ResponseEntity registerAirline(@ResponseBody AirlineRegistratioDto airlineDetails){
        log.info("airlineRegistration method got called with requestBody: " + airlineDetails.toString());
        log.info("calling airlineService -> registerAirline method");
        return new ResponseEntity(null, HttpStatus.CREATED);
    }
}
