package com.proyectoeventos.usuario_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @NotNull(message = "Es necesario ingresar el dni.")
    private Long dni;

    @NotBlank(message = "Es necesario ingresar el nombre.")
    private String nombre;
    @NotBlank(message = "Es necesario ingresar el apellido.")
    private String apellido;
    @NotNull(message = "Es necesario ingresar la fecha de nacimiento.")
    private LocalDate fechaNac;

    private String email;
    private String direccion;
}
