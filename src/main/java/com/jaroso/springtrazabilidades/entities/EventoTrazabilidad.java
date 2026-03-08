package com.jaroso.springtrazabilidades.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventoTrazabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEvento tipoEvento;

    @Column(nullable = false)
    private String ubicacion;

    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lote lote;
}
