package com.fbs.notification_api.controllers;

import com.fbs.notification_api.dto.AirlineRegistrationReqDto;
import com.fbs.notification_api.service.AppAdminNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/notify/appAdmin")
public class AppAdminNotificationController {

    AppAdminNotificationService  appAdminNotificationService;

    @Autowired
    public AppAdminNotificationController(AppAdminNotificationService appAdminNotificationService){
        this.appAdminNotificationService = appAdminNotificationService;
    }

    @PutMapping("/airline-registration")
    public ResponseEntity airlineRegistrationRequestNotification(@RequestBody AirlineRegistrationReqDto airlineRegistrationReqDto){
        log.info("Inside ailineRegistrationRequestNotification with payload: " + airlineRegistrationReqDto.toString());
        appAdminNotificationService.sendAirlineRegistrationRequestNotification(airlineRegistrationReqDto);
        return new ResponseEntity(new Object(), HttpStatus.OK);
    }
}
