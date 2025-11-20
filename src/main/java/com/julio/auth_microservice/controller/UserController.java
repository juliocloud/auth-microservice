package com.julio.auth_microservice.controller;

import com.julio.auth_microservice.auth.AuthManager;
import com.julio.auth_microservice.auth.JwtUtils;
import com.julio.auth_microservice.model.User;
import com.julio.auth_microservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final AuthManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public UserController(AuthManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        this.userService.create(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );

        return jwtUtils.generateToken(auth.getName());
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasRole('ADMIN')")
    public String testAdminRoute(){
        return "This is an admin route";
    }
}
