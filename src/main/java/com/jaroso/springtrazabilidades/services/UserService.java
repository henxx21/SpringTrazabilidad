package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.UserCreateDto;
import com.jaroso.springtrazabilidades.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByUsername(String username);
    UserDto saveUser(UserCreateDto user);
    void deleteUser(Long id);
}
