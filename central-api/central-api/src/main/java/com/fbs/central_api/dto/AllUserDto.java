package com.fbs.central_api.dto;

import com.fbs.central_api.models.AppUser;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class AllUserDto {

    List<AppUser> appUsers;
}
