package com.jaroso.springtrazabilidades.dtos;

import com.jaroso.springtrazabilidades.entities.EstadoLote;

import java.time.LocalDate;

public record LoteCreateDto(
        String numeroLote,
        LocalDate fechaProduccion,
        Integer cantidad,
        EstadoLote estado
) {
}
