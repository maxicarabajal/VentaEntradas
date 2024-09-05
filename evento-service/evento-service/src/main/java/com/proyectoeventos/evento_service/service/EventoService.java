package com.proyectoeventos.evento_service.service;

import com.proyectoeventos.evento_service.dto.EventoDTO;
import com.proyectoeventos.evento_service.exception.ResourceNotFoundException;
import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.Evento;
import com.proyectoeventos.evento_service.model.TipoEvento;
import com.proyectoeventos.evento_service.repository.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements IEventoService{

    @Autowired
    private IEventoRepository eventoRepository;



    @Override
    public List<Evento> findAllEvento() {
        return eventoRepository.findAll();
    }

    @Override
    public List<Evento> findAllEventoEstado(EstadoEvento estadoEvento) {
        return eventoRepository.findAllEventoByEstado(estadoEvento);
    }

    @Override
    public List<Evento> findAllEventoByTipo(TipoEvento tipoEvento) {
        return eventoRepository.findAllEventoByTipoEvento(tipoEvento);
    }

    @Override
    public Evento findEventoById(Long id) throws ResourceNotFoundException {
        return eventoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No se encontro el evento con id: "+id));
    }

    @Override
    public Evento findEventoByNombre(String nombre) throws ResourceNotFoundException {
        Optional<Evento> evento = eventoRepository.findEventoByNombre(nombre);
        if(!evento.isPresent()){
            throw new ResourceNotFoundException("No se encontro el evento con nombre: "+nombre);
        }
        return evento.get();
    }

    @Override
    public void createEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento();
    }

    @Override
    public void deleteEventoById(Long id) throws ResourceNotFoundException {
        Evento evento = this.findEventoById(id);
        eventoRepository.delete(evento);
    }

    @Override
    public void updateEventoById(Long id, EventoDTO eventoDTO) throws ResourceNotFoundException {
        Evento evento = this.findEventoById(id);
        if(eventoDTO.getNombre()!=null){
            evento.setNombre(eventoDTO.getNombre());
        }
        if(eventoDTO.getDescripcion()!=null){
            evento.setDescripcion(eventoDTO.getDescripcion());
        }
        if(eventoDTO.getDireccion()!=null){
            evento.setDireccion(eventoDTO.getDireccion());
        }
        if(eventoDTO.getTipoEvento()!=null){
            evento.setTipoEvento(eventoDTO.getTipoEvento());
        }
        if(eventoDTO.getEstadoEvento()!=null){
            evento.setEstadoEvento(eventoDTO.getEstadoEvento());
        }
        if(eventoDTO.getFechaEvento()!=null){
            evento.setFechaEvento(eventoDTO.getFechaEvento());
        }

        //falta agregar la logica de entradas

        eventoRepository.save(evento);
    }
}
