package com.jaroso.springtrazabilidades.mappers;

import com.jaroso.springtrazabilidades.dtos.EventoCreateDto;
import com.jaroso.springtrazabilidades.dtos.EventoDto;
import com.jaroso.springtrazabilidades.entities.EventoTrazabilidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventoTrazabilidadMapper {
    @Mapping(source = "timestamp", target = "fechaHora")
    EventoDto toDto(EventoTrazabilidad evento);

    @Mapping(source = "fechaHora", target = "timestamp")
    EventoTrazabilidad toEntity(EventoCreateDto eventoDto);
}
