package com.fbs.central_api.connectors;

import com.fbs.central_api.dto.AllUserDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

// Purpose of this class is to connect with db api endpoints
@Slf4j
@Component
public class DBApiConnector {

    RestTemplate restTemplate;

    @Autowired
    public DBApiConnector(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${db.api.url}")
    String dbApiBaseUrl; // takes value from application.properties

    public AppUser callRegisterUserEndpoint(AppUser user){
        log.info("Inside callRegisterUserEndpoint method with user: " + user.toString());
        // 1. Create URL that you want to call
        String url = dbApiBaseUrl + "/user/register";
        // 2. Provide rest method and request Body
        RequestEntity request = RequestEntity.post(url).body(user);
        log.info("Created request: " + request.toString());
        // 3. Hit or make the request i.e., click on send/enter button, by using RestTemplate class
        log.info("Calling DBApi register user endpoint");
        // exchange method is used to send request in parameters we pass i. url, ii. requestMethod, iii. requestBody, iv. responseType
        ResponseEntity<AppUser> response = restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        log.info("Response: " + response.toString());
        return response.getBody();
    }

    public Airline callRegisterAirlineEndpoint(Airline airline){
        log.info("Inside callRegisterAirlineEndpoint method with payload: " + airline.toString());
        String url = dbApiBaseUrl + "/airline/register";
        RequestEntity request = RequestEntity.post(url).body(airline);
        log.info("Created request: " + request.toString());
        log.info("Calling DBApi register Airline endpoint");
        ResponseEntity<Airline> response = restTemplate.exchange(url, HttpMethod.POST, request, Airline.class);
        log.info("Response: " + response.toString());
        return response.getBody();
    }

    public List<AppUser> callGetAllUserByUserType(String userType){
        String url = dbApiBaseUrl + "/user/get/" + userType;
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<AllUserDto> response = restTemplate.exchange(url, HttpMethod.GET, request, AllUserDto.class);
        return response.getBody().getAppUsers();
    }

//    public Airline callGetAirlineByIdEndpoint(UUID airlineId){
//    }
}
