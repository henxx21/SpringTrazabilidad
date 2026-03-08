package com.jaroso.springtrazabilidades.controllers;

import com.jaroso.springtrazabilidades.dtos.UserCreateDto;
import com.jaroso.springtrazabilidades.dtos.UserDto;
import com.jaroso.springtrazabilidades.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        Optional<UserDto> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
}
