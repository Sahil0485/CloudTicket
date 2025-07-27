package com.fbs.notification_api.dto;

import com.fbs.notification_api.models.Airline;
import com.fbs.notification_api.models.AppUser;
import lombok.Data;

@Data
public class AirlineRegistrationReqDto {

    AppUser admin;
    Airline airline;

}
