package com.julio.auth_microservice.repository;

import com.julio.auth_microservice.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public abstract class UserRepository implements JpaRepository<User, UUID> {
}
