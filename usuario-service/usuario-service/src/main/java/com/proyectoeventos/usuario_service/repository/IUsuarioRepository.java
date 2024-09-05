package com.proyectoeventos.usuario_service.repository;


import com.proyectoeventos.usuario_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
}
