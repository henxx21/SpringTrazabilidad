package com.jaroso.springtrazabilidades.mappers;

import com.jaroso.springtrazabilidades.dtos.LoteCreateDto;
import com.jaroso.springtrazabilidades.dtos.LoteDto;
import com.jaroso.springtrazabilidades.entities.Lote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoteMapper {
    LoteDto toDto(Lote lote);
    Lote toEntity(LoteCreateDto loteDto);
}
