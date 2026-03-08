package com.jaroso.springtrazabilidades.repositories;

import com.jaroso.springtrazabilidades.entities.Producto;
import com.jaroso.springtrazabilidades.entities.TipoEvento;
import com.jaroso.springtrazabilidades.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByUsuario(Usuario usuario);
    Optional<Producto> findByCodigoAndUsuario(String codigo, Usuario usuario);
}
