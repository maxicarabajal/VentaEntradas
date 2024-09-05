package com.proyectoeventos.evento_service.controller;

import com.proyectoeventos.evento_service.dto.EventoDTO;
import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.Evento;
import com.proyectoeventos.evento_service.model.TipoEvento;
import com.proyectoeventos.evento_service.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
@Validated
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @GetMapping("/get/all")
    public List<Evento> getAllEvento(){
        return eventoService.findAllEvento();
    }

    @GetMapping("/find/all/tipoevento/{tipoEvento}")
    private List<Evento> findAllTipoEvento(@PathVariable TipoEvento tipoEvento){
        return eventoService.findAllEventoByTipo(tipoEvento);
    }

    @GetMapping("/find/all/estadoevento/{estado}")
    private List<Evento> findAllEstadoEvento(@PathVariable EstadoEvento estado){
        return eventoService.findAllEventoEstado(estado);
    }

    @GetMapping("/find/nombre/{nombre}")
    private Evento findEventoByNombre(@PathVariable String nombre){
        return eventoService.findEventoByNombre(nombre);
    }

    @GetMapping("/find/id/{id}")
    private Evento findEventoById(@PathVariable Long id){
        return eventoService.findEventoById(id);
    }

    @PostMapping("/create")
    private void createEvento(@RequestBody EventoDTO eventoDTO){
        eventoService.createEvento(eventoDTO);
    }

    //Falta Delete y Mapping
}
