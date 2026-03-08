package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.EventoCreateDto;
import com.jaroso.springtrazabilidades.dtos.EventoDto;
import com.jaroso.springtrazabilidades.entities.EventoTrazabilidad;
import com.jaroso.springtrazabilidades.entities.Lote;
import com.jaroso.springtrazabilidades.entities.TipoEvento;
import com.jaroso.springtrazabilidades.mappers.EventoTrazabilidadMapper;
import com.jaroso.springtrazabilidades.repositories.EventoTrazabilidadRepository;
import com.jaroso.springtrazabilidades.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoTrazabilidadServiceImpl implements EventoTrazabilidadService {
        // Implementación de métodos para gestionar eventos de trazabilidad
    @Autowired private EventoTrazabilidadRepository eventoRepository;

    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private EventoTrazabilidadMapper mapper;

    @Override
    public EventoDto saveEvento(Long loteId, EventoCreateDto evento) {
        Optional<Lote> lote = loteRepository.findById(loteId);

        EventoTrazabilidad eventoEntity = mapper.toEntity(evento);
        lote.ifPresent(eventoEntity::setLote);

        return mapper.toDto(eventoRepository.save(eventoEntity));
    }

    @Override
    public List<EventoDto> findByLoteId(Long loteId) {
        Optional<Lote> lote = loteRepository.findById(loteId);
        return lote.map(value -> eventoRepository.findByLoteOrderByTimestampAsc(value).stream().map(mapper::toDto).toList())
                .orElse(List.of());
    }

    @Override
    public List<EventoDto> findRutaByLoteId(Long loteId) {
        Optional<Lote> lote = loteRepository.findById(loteId);
        return lote.map(value -> eventoRepository.findByLoteOrderByTimestampAsc(value).stream().map(mapper::toDto).toList())
                .orElse(List.of());
    }

    @Override
    public List<EventoDto> findByFiltros(Long loteId, TipoEvento tipoEvento, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        Optional<Lote> lote = loteRepository.findById(loteId);

        if (lote.isEmpty()) {
            return List.of();
        }

        if (tipoEvento != null && fechaInicio != null && fechaFin != null) {
            return eventoRepository.findByLoteAndTipoEventoAndTimestampBetweenOrderByTimestampAsc(
                    lote.get(), tipoEvento, fechaInicio, fechaFin
            ).stream().map(mapper::toDto).toList();
        }

        if (tipoEvento != null) {
            return eventoRepository.findByLoteAndTipoEventoOrderByTimestampAsc(
                    lote.get(), tipoEvento
            ).stream().map(mapper::toDto).toList();
        }

        if (fechaInicio != null && fechaFin != null) {
            return eventoRepository.findByLoteAndTimestampAfterOrderByTimestampAsc(
                    lote.get(), fechaInicio, fechaFin
            ).stream().map(mapper::toDto).toList();
        }

        return eventoRepository.findByLoteOrderByTimestampAsc(lote.get())
                .stream().map(mapper::toDto).toList();
    }
}

