package com.jaroso.springtrazabilidades.controllers;

import com.jaroso.springtrazabilidades.dtos.ProductoCreateDto;
import com.jaroso.springtrazabilidades.dtos.ProductoDto;
import com.jaroso.springtrazabilidades.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Long id) {
        Optional<ProductoDto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoCreateDto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.saveProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id, @RequestBody ProductoCreateDto producto) {
        ProductoDto productoActualizado = productoService.updateProducto(id, producto);

        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        Optional<ProductoDto> producto = productoService.findById(id);

        if (producto.isPresent()) {
            productoService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
