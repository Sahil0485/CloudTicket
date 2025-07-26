package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBApiConnector;
import com.fbs.central_api.dto.AirlineRegistratioDto;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AirlineService {

    Mapper mapper;
    DBApiConnector dbApiConnector;

    @Autowired
    AirlineService(Mapper mapper, DBApiConnector dbApiConnector){
        this.mapper = mapper;
        this.dbApiConnector = dbApiConnector;
    }

    public void registerAirline(AirlineRegistratioDto airlineRegistratioDto){
        log.info("airlineService registerAirline method called: " + airlineRegistratioDto.toString());
        AppUser airlineAdmin = mapper.mapAirlineDetailsDtoToAppUser(airlineRegistratioDto);
        log.info("Calling DBApi connector callCreateUserMethod with payload: " + airlineAdmin.toString());
        airlineAdmin = dbApiConnector.callRegisterUserEndpoint(airlineAdmin);

    }
}
