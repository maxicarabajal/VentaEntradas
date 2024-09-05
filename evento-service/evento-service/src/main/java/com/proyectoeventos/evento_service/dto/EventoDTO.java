package com.proyectoeventos.evento_service.dto;

import com.proyectoeventos.evento_service.model.EstadoEvento;
import com.proyectoeventos.evento_service.model.TipoEvento;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
    private Long idEvento;

    private String nombre;
    private String descripcion;
    private TipoEvento tipoEvento;
    private String direccion;
    private LocalDate fechaEvento;
    private EstadoEvento estadoEvento;
    private List<EntradaDTO> entradas;
}
