package com.fbs.central_api.dto;

import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import lombok.Data;

@Data
public class AirlineRegistrationReqDto {

    AppUser appAdmin;
    Airline airline;
}
