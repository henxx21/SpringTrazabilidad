package com.jaroso.springtrazabilidades.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "lotes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroLote;

    @Column(nullable = false)
    private LocalDate fechaProduccion;

    @Column(nullable = false)
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoLote estado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventoTrazabilidad> eventos = new ArrayList<>();
}
