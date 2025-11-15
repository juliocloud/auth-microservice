package com.julio.auth_microservice.model;

import com.julio.auth_microservice.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    String firstName;

    String lastName;

    String password;

    String email;

    @ElementCollection(fetch = FetchType.EAGER)
    Set<Role> roles;
}
