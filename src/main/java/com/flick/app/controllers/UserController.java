package com.flick.app.controllers;

import com.flick.app.models.User;
import com.flick.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        ResponseEntity<?> responseEntity;
        try {
            responseEntity = ResponseEntity.status(201).body(this.userService.register(user));
        } catch (Exception exception) {
            responseEntity = ResponseEntity.status(409).body(exception.getMessage());
        }
        return responseEntity;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        ResponseEntity<?> responseEntity;
        try {
            responseEntity = ResponseEntity.status(200).body(this.userService.login(user.getEmail(), user.getPassword()));
        } catch (Exception exception) {
            responseEntity = ResponseEntity.status(409).body(exception.getMessage());
        }
        return responseEntity;
    }
}
