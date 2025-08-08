package com.fbs.central_api.service;

import com.fbs.central_api.connectors.NotificationApiConnector;
import com.fbs.central_api.dto.AirlineRegistrationReqDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MailService {

    NotificationApiConnector notificationApiConnector;

    @Autowired
    public MailService(NotificationApiConnector notificationApiConnector){
        this.notificationApiConnector = notificationApiConnector;
    }

    //for mailing all system Admins
    public void mailSystemAdminForAirlineRegistration(List<AppUser> systemAdmins, Airline airline){
        for(AppUser systemAdmin: systemAdmins){
            AirlineRegistrationReqDto airlineRegistrationReqDto = new AirlineRegistrationReqDto();
            airlineRegistrationReqDto.setAirline(airline);
            airlineRegistrationReqDto.setAppAdmin(systemAdmin);
            notificationApiConnector.notifySystemAdminForAirlineRegistration(airlineRegistrationReqDto);
        }
    }
}
