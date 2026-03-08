package com.jaroso.springtrazabilidades.dtos;

public record UserCreateDto(
    String name,
    String email,
    String password
) {
}
