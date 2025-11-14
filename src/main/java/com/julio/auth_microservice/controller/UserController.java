package com.julio.auth_microservice.controller;

import com.julio.auth_microservice.model.User;
import com.julio.auth_microservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(User user){
        this.userService.create(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "This endpoint is not secure";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminProfile(){
        return "This is an admin route";
    }
}
