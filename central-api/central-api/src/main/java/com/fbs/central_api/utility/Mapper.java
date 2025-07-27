package com.fbs.central_api.utility;

import com.fbs.central_api.dto.AirlineRegistratioDto;
import com.fbs.central_api.enums.AirlineStatus;
import com.fbs.central_api.enums.UserStatus;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Mapper {

    public AppUser mapAirlineDetailsDtoToAppUser(AirlineRegistratioDto airlineDetails){
        AppUser airlineAdmin = new AppUser();
        airlineAdmin.setEmail(airlineDetails.getEmail());
        airlineAdmin.setName(airlineDetails.getAirlineName() + " Admin");
        airlineAdmin.setUserType(UserType.AIRLINE_ADMIN.toString());
        airlineAdmin.setNumber(airlineDetails.getContactNumber());
        airlineAdmin.setVerified(false);
        airlineAdmin.setStatus(UserStatus.INACTIVE.toString());
        airlineAdmin.setPassword(airlineDetails.getPassword());
        airlineAdmin.setCreatedAt(LocalDateTime.now());
        airlineAdmin.setUpdatedAt(LocalDateTime.now());
        return airlineAdmin;
    }

    public Airline mapAirlineDetailsDtoToAirline(AirlineRegistratioDto airlineRegistratioDto, AppUser airlineAdmin){
        Airline airline = new Airline();
        airline.setAirlineName(airlineRegistratioDto.getAirlineName());
        airline.setStatus(AirlineStatus.INACTIVE.toString());
        airline.setAdmin(airlineAdmin);
        airline.setEmployees(airlineRegistratioDto.getEmployees());
        airline.setWebsite(airlineRegistratioDto.getWebsite());
        airline.setCompanyName(airlineRegistratioDto.getCompanyName());
        airline.setTotalFlights(airlineRegistratioDto.getTotalFlights());
        airline.setCreatedAt(LocalDateTime.now());
        airline.setUpdatedAt(LocalDateTime.now());
        return airline;
    }
}
