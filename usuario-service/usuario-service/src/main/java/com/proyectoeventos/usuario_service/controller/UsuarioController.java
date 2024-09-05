package com.proyectoeventos.usuario_service.controller;


import com.proyectoeventos.usuario_service.dto.UsuarioDTO;
import com.proyectoeventos.usuario_service.model.Usuario;
import com.proyectoeventos.usuario_service.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/get/all")
    public List<Usuario> getAllUsuario(){
        return usuarioService.findAllUsuario();
    }

    @GetMapping("/find/dni/{dni}")
    public Usuario findUsuarioByDni(@PathVariable Long dni){
        return usuarioService.findUsuarioByDni(dni);
    }

    @PostMapping("/create")
    public void createUsuario(@Valid @RequestBody Usuario usuario){
        usuarioService.createUsuario(usuario);
    }

    @DeleteMapping("/delete/dni/{dni}")
    public void deleteUsuario(@PathVariable Long dni){
        usuarioService.deleteUsuarioByDni(dni);
    }

    @PutMapping("/update/dni/{dni}")
    public void updateUsuario(@PathVariable Long dni, @RequestBody UsuarioDTO usuarioDTO){
        usuarioService.updateUsuarioByDni(dni,usuarioDTO);
    }
}
