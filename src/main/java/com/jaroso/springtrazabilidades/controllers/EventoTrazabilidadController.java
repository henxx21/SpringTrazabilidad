package com.jaroso.springtrazabilidades.controllers;

import com.jaroso.springtrazabilidades.dtos.EventoCreateDto;
import com.jaroso.springtrazabilidades.dtos.EventoDto;
import com.jaroso.springtrazabilidades.entities.TipoEvento;
import com.jaroso.springtrazabilidades.services.EventoTrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EventoTrazabilidadController {
    @Autowired
    private EventoTrazabilidadService eventoService;

    @PostMapping("/api/lotes/{id}/eventos")
    public ResponseEntity<EventoDto> createEvento(@PathVariable Long id, @RequestBody EventoCreateDto evento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.saveEvento(id, evento));
    }

    @GetMapping("/api/lotes/{id}/eventos")
    public ResponseEntity<List<EventoDto>> getEventosByLote(
            @PathVariable Long id,
            @RequestParam(required = false) TipoEvento tipoEvento,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin
    ) {
        return ResponseEntity.ok(eventoService.findByFiltros(id, tipoEvento, fechaInicio, fechaFin));
    }

    @GetMapping("/api/lotes/{id}/ruta")
    public ResponseEntity<List<EventoDto>> getRutaLote(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.findRutaByLoteId(id));
    }
}
