package com.proyectoeventos.evento_service.service;

import com.proyectoeventos.evento_service.dto.EventoDTO;
import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.Evento;
import com.proyectoeventos.evento_service.model.TipoEvento;

import java.util.List;

public interface IEventoService {

    List<Evento> findAllEvento();

    List<Evento> findAllEventoEstado(EstadoEvento estadoEvento);

    List<Evento> findAllEventoByTipo(TipoEvento tipoEvento);

    Evento findEventoById(Long id);

    Evento findEventoByNombre(String nombre);

    void createEvento(EventoDTO eventoDTO);

    void deleteEventoById(Long id);

    void updateEventoById(Long id, EventoDTO eventoDTO);
}
