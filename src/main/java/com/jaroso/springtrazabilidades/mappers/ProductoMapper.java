package com.jaroso.springtrazabilidades.mappers;

import com.jaroso.springtrazabilidades.dtos.ProductoCreateDto;
import com.jaroso.springtrazabilidades.dtos.ProductoDto;
import com.jaroso.springtrazabilidades.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDto toDto(Producto producto);
    Producto toEntity(ProductoCreateDto productoDto);
}
