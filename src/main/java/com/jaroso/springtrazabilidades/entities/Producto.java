package com.jaroso.springtrazabilidades.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lote> lotes = new ArrayList<>();
}
