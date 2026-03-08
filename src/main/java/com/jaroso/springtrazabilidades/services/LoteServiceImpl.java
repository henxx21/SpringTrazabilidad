package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.LoteCreateDto;
import com.jaroso.springtrazabilidades.dtos.LoteDto;
import com.jaroso.springtrazabilidades.dtos.LoteEstadoUpdateDto;
import com.jaroso.springtrazabilidades.entities.Lote;
import com.jaroso.springtrazabilidades.entities.Producto;
import com.jaroso.springtrazabilidades.mappers.LoteMapper;
import com.jaroso.springtrazabilidades.repositories.LoteRepository;
import com.jaroso.springtrazabilidades.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImpl implements LoteService {
    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private LoteMapper mapper;

    @Override
    public List<LoteDto> findByProductoId(Long productoId) {
        Optional<Producto> producto = productoRepository.findById(productoId);
        return producto.map(value -> loteRepository.findByProducto(value).stream().map(mapper::toDto).toList())
                .orElse(List.of());
    }

    @Override
    public Optional<LoteDto> findById(Long id) {
        return loteRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public LoteDto saveLote(Long productoId, LoteCreateDto lote) {
        Optional<Producto> producto = productoRepository.findById(productoId);

        Lote loteEntity = mapper.toEntity(lote);
        producto.ifPresent(loteEntity::setProducto);

        return mapper.toDto(loteRepository.save(loteEntity));
    }

    @Override
    public LoteDto updateEstado(Long id, LoteEstadoUpdateDto estadoDto) {
        Optional<Lote> loteOptional = loteRepository.findById(id);

        if (loteOptional.isPresent()) {
            Lote lote = loteOptional.get();
            lote.setEstado(estadoDto.estado());
            return mapper.toDto(loteRepository.save(lote));
        }

        return null;
    }
}
