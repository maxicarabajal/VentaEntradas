package com.proyectoeventos.evento_service.repository;


import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.Evento;
import com.proyectoeventos.evento_service.model.TipoEvento;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEventoRepository extends JpaRepository<Evento,Long> {

    //BUSCAMOS TODOS LOS EVENTOS SEGUN EL ESTADO QUE QUEREMOS, ACTIVOS O INACTIVOS
    @Query("SELECT e FROM Evento e WHERE e.estadoEvento = :estado")
    List<Evento> findAllEventoByEstado(@Param("estado")EstadoEvento estado);

    //BUSCAMOS TODOS LOS EVENTOS SEGUN EL TIPO DE EVENTO, MUSICAL, DEPORTIVO, ETC
    @Query("SELECT e FROM Evento e WHERE e.tipoEvento = :tipoEvento")
    List<Evento> findAllEventoByTipoEvento(@Param("tipoEvento")TipoEvento tipoEvento);

    @Query("SELECT e FROM Evento e WHERE e.nombre = :nombre")
    Optional<Evento> findEventoByNombre(@Param("nombre")String nombre);
}
