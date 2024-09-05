package com.proyectoeventos.usuario_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String email;
    private String direccion;
}
