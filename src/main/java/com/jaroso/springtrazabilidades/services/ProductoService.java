package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.ProductoCreateDto;
import com.jaroso.springtrazabilidades.dtos.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoDto> findAll();
    Optional<ProductoDto> findById(Long id);
    ProductoDto saveProducto(ProductoCreateDto producto);
    ProductoDto updateProducto(Long id, ProductoCreateDto producto);
    void deleteProducto(Long id);
}

