package com.apw.sportmania.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apw.sportmania.entities.User;
import com.apw.sportmania.entities.UserCredentials;
import com.apw.sportmania.exceptions.AuthenticationException;
import com.apw.sportmania.exceptions.InvalidCodeException;
import com.apw.sportmania.exceptions.UserAlreadyExistsException;
import com.apw.sportmania.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    @PostMapping("/new-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserCredentials userCredentials) {
        try {
            User authenticatedUser = userService.authenticateUser(userCredentials.getEmail(), userCredentials.getPassword(), userCredentials.getCode());
            return ResponseEntity.ok("User authenticated");
        } catch (AuthenticationException | InvalidCodeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
