package com.fbs.notification_api.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppUser {

    UUID id;
    String name;
    String email;
    String password;
    Long number;
    boolean isVerified;
    String userType;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
