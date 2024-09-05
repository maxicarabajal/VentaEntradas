package com.proyectoeventos.usuario_service.service;

import com.proyectoeventos.usuario_service.dto.UsuarioDTO;
import com.proyectoeventos.usuario_service.exception.ResourceNotFoundException;
import com.proyectoeventos.usuario_service.model.Usuario;
import com.proyectoeventos.usuario_service.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuarioByDni(Long dni) throws ResourceNotFoundException{
        return usuarioRepository.findById(dni)
                .orElseThrow(()->new ResourceNotFoundException("No se encontro un Usuario con dni: "+dni));
    }

    @Override
    public void createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuarioByDni(Long dni) throws ResourceNotFoundException{
        Usuario usuario = this.findUsuarioByDni(dni);
        usuarioRepository.delete(usuario);
    }

    @Override
    public void updateUsuarioByDni(Long dni, UsuarioDTO usuarioDTO) throws ResourceNotFoundException {
        Usuario usuario1 = this.findUsuarioByDni(dni);
        if(usuarioDTO.getNombre()!=null){
            usuario1.setNombre(usuarioDTO.getNombre());
        }
        if(usuarioDTO.getApellido()!=null){
            usuario1.setApellido(usuarioDTO.getApellido());
        }
        if(usuarioDTO.getEmail()!=null){
            usuario1.setEmail(usuarioDTO.getEmail());
        }
        if(usuarioDTO.getDireccion()!=null){
            usuario1.setDireccion(usuarioDTO.getDireccion());
        }
        if(usuarioDTO.getFechaNac()!=null){
            usuario1.setFechaNac(usuarioDTO.getFechaNac());
        }
        usuarioRepository.save(usuario1);
    }
}
