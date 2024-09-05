package com.proyectoeventos.usuario_service.service;



import com.proyectoeventos.usuario_service.dto.UsuarioDTO;
import com.proyectoeventos.usuario_service.exception.ResourceNotFoundException;
import com.proyectoeventos.usuario_service.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAllUsuario();

    Usuario findUsuarioByDni(Long dni) throws ResourceNotFoundException;

    void createUsuario(Usuario usuario);

    void deleteUsuarioByDni(Long dni) throws ResourceNotFoundException;

    void updateUsuarioByDni(Long dni, UsuarioDTO usuarioDTO) throws ResourceNotFoundException;
}
