package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.LoteCreateDto;
import com.jaroso.springtrazabilidades.dtos.LoteDto;
import com.jaroso.springtrazabilidades.dtos.LoteEstadoUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface LoteService {

    List<LoteDto> findByProductoId(Long productoId);
    Optional<LoteDto> findById(Long id);
    LoteDto saveLote(Long productoId, LoteCreateDto lote);
    LoteDto updateEstado(Long id, LoteEstadoUpdateDto estadoDto);
}
