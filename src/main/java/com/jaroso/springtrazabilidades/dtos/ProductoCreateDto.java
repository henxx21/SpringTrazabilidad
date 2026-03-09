package com.jaroso.springtrazabilidades.dtos;

public record ProductoCreateDto(
        String codigo,
        String nombre,
        String descripcion,
        String username
) {
}

