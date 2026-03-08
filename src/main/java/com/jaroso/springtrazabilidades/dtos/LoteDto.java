package com.jaroso.springtrazabilidades.dtos;

import com.jaroso.springtrazabilidades.entities.EstadoLote;

import java.time.LocalDate;

public record LoteDto(
        Long id,
        String numeroLote,
        LocalDate fechaProduccion,
        Integer cantidad,
        EstadoLote estado
) {
}
