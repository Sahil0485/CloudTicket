package com.fbs.db_api.controllers;

import com.fbs.db_api.dto.AllUsersDto;
import com.fbs.db_api.models.AppUser;
import com.fbs.db_api.repositories.AppUserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUserController {

    // we are not doing autowired here because it gets error out during the time of unit test cases
    AppUserRepo appUserRepo;

    // instead of that we create constructor base autowiring
    public AppUserController(AppUserRepo appUserRepo){
        this.appUserRepo = appUserRepo;
    }

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody AppUser user){
        AppUser userResp = appUserRepo.save(user);
        return new ResponseEntity(userResp, HttpStatus.CREATED); // sends response with created status code i.e., 201
    }

    @GetMapping("/get/{userType}")
    public ResponseEntity GetAllUserByUserType(@PathVariable String userType){
        List<AppUser> users = appUserRepo.findByUserType(userType);
        AllUsersDto allUsers = new AllUsersDto(users);
        allUsers.setAppUsers(users);
        return new ResponseEntity(allUsers, HttpStatus.OK);
    }
}
