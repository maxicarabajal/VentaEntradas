package com.proyectoeventos.evento_service.repository;


import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEventoRepository extends JpaRepository<Evento,Long> {

    @Query("SELECT e FROM Evento e WHERE e.estadoEvento = :estado")
    List<Evento> findAllEventoByEstado(@Param("estado")EstadoEvento estado);



}
