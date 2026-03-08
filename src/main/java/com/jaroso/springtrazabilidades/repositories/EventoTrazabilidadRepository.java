package com.jaroso.springtrazabilidades.repositories;

import com.jaroso.springtrazabilidades.entities.EventoTrazabilidad;
import com.jaroso.springtrazabilidades.entities.Lote;
import com.jaroso.springtrazabilidades.entities.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoTrazabilidadRepository extends JpaRepository<EventoTrazabilidad, Long> {

    List<EventoTrazabilidad> findByLoteOrderByTimestampAsc(Lote lote);

    List<EventoTrazabilidad> findByLoteAndTipoEventoOrderByTimestampAsc(Lote lote, TipoEvento tipoEvento);

    List<EventoTrazabilidad> findByLoteAndTimestampAfterOrderByTimestampAsc(
            Lote lote,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    );

    List<EventoTrazabilidad> findByLoteAndTipoEventoAndTimestampBetweenOrderByTimestampAsc(
            Lote lote,
            TipoEvento tipoEvento,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    );
}
