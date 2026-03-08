package com.jaroso.springtrazabilidades.dtos;

import com.jaroso.springtrazabilidades.entities.TipoEvento;

import java.time.LocalDateTime;

public record EventoCreateDto(
        LocalDateTime fechaHora,
        TipoEvento tipoEvento,
        String ubicacion,
        String observaciones
) {
}
