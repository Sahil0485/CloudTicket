package com.fbs.central_api.connectors;

import com.fbs.central_api.dto.AirlineRegistrationReqDto;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class NotificationApiConnector {

    RestTemplate restTemplate;

    @Autowired
    public NotificationApiConnector(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${notification.api.url}")
    String notificationBaseUrl;

    public void notifySystemAdminForAirlineRegistration(AirlineRegistrationReqDto airlineRegistrationReqDto){
        String url = notificationBaseUrl + "appAdmin/airline-registration";
        RequestEntity request = RequestEntity.put(url).body(airlineRegistrationReqDto);
        ResponseEntity<Object> resp = restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
        log.info("Response of notification via mail: " + resp);
    }
}
