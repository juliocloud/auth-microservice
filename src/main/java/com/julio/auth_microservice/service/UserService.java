package com.julio.auth_microservice.service;

import com.julio.auth_microservice.exception.UserAlreadyExistException;
import com.julio.auth_microservice.model.User;
import com.julio.auth_microservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByUserName(String email){
        return this.userRepository.findUserByEmail(email);
    }

    public void create(User user) {
        if(this.getByUserName(user.getEmail()).isPresent())
            throw new UserAlreadyExistException();
        this.userRepository.save(user);
    }
}