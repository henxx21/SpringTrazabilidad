package com.jaroso.springtrazabilidades.repositories;

import com.jaroso.springtrazabilidades.entities.Lote;
import com.jaroso.springtrazabilidades.entities.Producto;
import com.jaroso.springtrazabilidades.entities.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
    List<Lote> findByProducto(Producto producto);

    Optional<Lote> findByNumeroLoteAndProducto(String numeroLote, Producto producto);

}
