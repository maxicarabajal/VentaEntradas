package com.proyectoeventos.evento_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEvento;

    @NotBlank(message = "Ingresar el nombre del evento.")
    private String nombre;

    @NotBlank(message = "Ingresar la descripcion del evento.")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Ingresar el tipo de evento.")
    private TipoEvento tipoEvento;

    @NotBlank(message = "Ingresar la direccion del evento.")
    private String direccion;

    @NotNull(message = "Ingresar la fecha del evento.")
    private LocalDate fechaEvento;

    @Enumerated(EnumType.STRING)
    private EstadoEvento estadoEvento;

    @ElementCollection
    private List<Long> entradas;

}
