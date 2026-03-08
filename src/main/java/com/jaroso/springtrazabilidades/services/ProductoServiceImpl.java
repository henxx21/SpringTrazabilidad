package com.jaroso.springtrazabilidades.services;

import com.jaroso.springtrazabilidades.dtos.ProductoCreateDto;
import com.jaroso.springtrazabilidades.dtos.ProductoDto;
import com.jaroso.springtrazabilidades.entities.Producto;
import com.jaroso.springtrazabilidades.entities.Usuario;
import com.jaroso.springtrazabilidades.mappers.ProductoMapper;
import com.jaroso.springtrazabilidades.repositories.ProductoRepository;
import com.jaroso.springtrazabilidades.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductoMapper mapper;

    @Override
    public List<ProductoDto> findAll() {
        return productoRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<ProductoDto> findById(Long id) {
        return productoRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public ProductoDto saveProducto(ProductoCreateDto producto) {
        Optional<Usuario> usuario = userRepository.findByUsername(producto.username());

        Producto productoEntity = mapper.toEntity(producto);
        usuario.ifPresent(productoEntity::setUsuario);

        return mapper.toDto(productoRepository.save(productoEntity));
    }

    @Override
    public ProductoDto updateProducto(Long id, ProductoCreateDto producto) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (productoOptional.isPresent()) {
            Producto productoEntity = productoOptional.get();
            productoEntity.setCodigo(producto.codigo());
            productoEntity.setNombre(producto.nombre());
            productoEntity.setDescripcion(producto.descripcion());

            Optional<Usuario> usuario = userRepository.findByUsername(producto.username());
            usuario.ifPresent(productoEntity::setUsuario);

            return mapper.toDto(productoRepository.save(productoEntity));
        }

        return null;
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
