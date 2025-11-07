package com.julio.auth_microservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        System.out.println("Hello world");
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
