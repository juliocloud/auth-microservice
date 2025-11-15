package com.julio.auth_microservice.service;

import com.julio.auth_microservice.model.User;
import com.julio.auth_microservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user){
        this.userRepository.save(user);
    }
}