package com.julio.auth_microservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    UUID id;
    String firstName;
    String lastName;
    String password;

}
