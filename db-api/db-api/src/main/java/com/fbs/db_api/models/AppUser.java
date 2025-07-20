package com.fbs.db_api.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    //using column annotations is not compulsory it is used for property of column in table
    @Column(name = "name", nullable = false)
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
