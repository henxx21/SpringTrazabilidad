package com.jaroso.springtrazabilidades.dtos;

public record ProductoDto(
        Long id,
        String codigo,
        String nombre,
        String descripcion
) {
}
