package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.UserCreateDto;
import com.jaroso.springtrazabilidades.dtos.UserDto;
import com.jaroso.springtrazabilidades.entities.Usuario;
import com.jaroso.springtrazabilidades.mappers.UserMapper;
import com.jaroso.springtrazabilidades.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return userRepository.findByUsername(username).map(mapper::toDto);
    }

    @Override
    public UserDto saveUser(UserCreateDto user) {
        Usuario usuario = mapper.toEntity(user);
        return mapper.toDto(userRepository.save(usuario));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
