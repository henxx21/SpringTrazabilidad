package com.jaroso.springtrazabilidades.dtos;

public record UserCreateDto(
        String username,
        String password,
        String nombre,
        String email
) {
}
