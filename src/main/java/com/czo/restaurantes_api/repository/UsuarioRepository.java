package com.czo.restaurantes_api.repository;

import com.czo.restaurantes_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    Optional<Usuario> findByEmailIgnoreCase(String email);
    Optional<Usuario> findByLoginIgnoreCase(String login);
}