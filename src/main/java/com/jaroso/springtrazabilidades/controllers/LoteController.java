package com.jaroso.springtrazabilidades.controllers;

import com.jaroso.springtrazabilidades.dtos.LoteCreateDto;
import com.jaroso.springtrazabilidades.dtos.LoteDto;
import com.jaroso.springtrazabilidades.dtos.LoteEstadoUpdateDto;
import com.jaroso.springtrazabilidades.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoteController {

    @Autowired
    private LoteService loteService;

    @GetMapping("/api/productos/{id}/lotes")
    public ResponseEntity<List<LoteDto>> getLotesByProducto(@PathVariable Long id) {
        return ResponseEntity.ok(loteService.findByProductoId(id));
    }

    @PostMapping("/api/productos/{id}/lotes")
    public ResponseEntity<LoteDto> createLote(@PathVariable Long id, @RequestBody LoteCreateDto lote) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loteService.saveLote(id, lote));
    }

    @GetMapping("/api/lotes/{id}")
    public ResponseEntity<LoteDto> getLoteById(@PathVariable Long id) {
        Optional<LoteDto> lote = loteService.findById(id);
        return lote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/api/lotes/{id}/estado")
    public ResponseEntity<LoteDto> updateEstadoLote(@PathVariable Long id, @RequestBody LoteEstadoUpdateDto estadoDto) {
        LoteDto loteActualizado = loteService.updateEstado(id, estadoDto);

        if (loteActualizado != null) {
            return ResponseEntity.ok(loteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
