package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBApiConnector;
import com.fbs.central_api.dto.AirlineRegistratioDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AirlineService {

    Mapper mapper;
    DBApiConnector dbApiConnector;
    UserService userService;
    MailService mailService;

    @Autowired
    AirlineService(Mapper mapper, DBApiConnector dbApiConnector, UserService userService, MailService mailService){
        this.mapper = mapper;
        this.dbApiConnector = dbApiConnector;
        this.userService = userService;
        this.mailService = mailService;
    }

//    public Airline getAirlineById(UUID airlineId){
//
//    }

    public Airline registerAirline(AirlineRegistratioDto airlineRegistratioDto){
        log.info("airlineService registerAirline method called: " + airlineRegistratioDto.toString());
        AppUser airlineAdmin = mapper.mapAirlineDetailsDtoToAppUser(airlineRegistratioDto);
        log.info("Calling DBApi connector callCreateUserMethod with payload: " + airlineAdmin.toString());
        airlineAdmin = dbApiConnector.callRegisterUserEndpoint(airlineAdmin);
        Airline airline = mapper.mapAirlineDetailsDtoToAirline(airlineRegistratioDto, airlineAdmin);
        airline = dbApiConnector.callRegisterAirlineEndpoint(airline);
        List<AppUser> systemAdminList = userService.getSystemAdmins();
        mailService.mailSystemAdminForAirlineRegistration(systemAdminList, airline);
        return airline;
    }

//    public Airline acceptAirlineRequest(UUID airlineId){
//        Airline airline = new Airline();
//        log.info("airlineId: " + airlineId);
//    }
}
