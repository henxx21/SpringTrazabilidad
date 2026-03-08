package com.jaroso.springtrazabilidades.dtos;

public record UserDto(
        Long id,
        String username,
        String nombre,
        String email
) {
}
