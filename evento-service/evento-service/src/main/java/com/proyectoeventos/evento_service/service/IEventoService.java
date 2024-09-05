package com.proyectoeventos.evento_service.service;

import com.proyectoeventos.evento_service.dto.EventoDTO;
import com.proyectoeventos.evento_service.exception.ResourceNotFoundException;
import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.Evento;
import com.proyectoeventos.evento_service.model.TipoEvento;

import java.util.List;

public interface IEventoService {

    List<Evento> findAllEvento();

    List<Evento> findAllEventoEstado(EstadoEvento estadoEvento);

    List<Evento> findAllEventoByTipo(TipoEvento tipoEvento);

    Evento findEventoById(Long id) throws ResourceNotFoundException;

    Evento findEventoByNombre(String nombre) throws ResourceNotFoundException;

    void createEvento(EventoDTO eventoDTO);

    void deleteEventoById(Long id) throws ResourceNotFoundException;

    void updateEventoById(Long id, EventoDTO eventoDTO) throws ResourceNotFoundException;
}
