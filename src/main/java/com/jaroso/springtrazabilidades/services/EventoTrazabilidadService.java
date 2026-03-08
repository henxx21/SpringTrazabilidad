package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.EventoCreateDto;
import com.jaroso.springtrazabilidades.dtos.EventoDto;
import com.jaroso.springtrazabilidades.entities.TipoEvento;

import java.time.LocalDateTime;
import java.util.List;

public interface EventoTrazabilidadService {
    EventoDto saveEvento(Long loteId, EventoCreateDto evento);
    List<EventoDto> findByLoteId(Long loteId);
    List<EventoDto> findRutaByLoteId(Long loteId);
    List<EventoDto> findByFiltros(Long loteId, TipoEvento tipoEvento, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
