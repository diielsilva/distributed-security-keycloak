package com.ddev.userservice.controllers;

import com.ddev.userservice.dtos.UserRequest;
import com.ddev.userservice.dtos.UserResponse;
import com.ddev.userservice.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest requestBody) {
        UserResponse responseBody = userService.create(requestBody);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
}
