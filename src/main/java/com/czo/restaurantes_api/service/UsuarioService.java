package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.UsuarioRequestDTO;
import com.czo.restaurantes_api.dto.UsuarioResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    UsuarioResponseDTO salvar(UsuarioRequestDTO usuarioRequestDTO);

    List<UsuarioResponseDTO> buscarUsuarios(String nome);

    void atualizarUsuarios(UUID id, UsuarioRequestDTO usuarioRequestDTO);

    void atualizarSenha(UUID id, UsuarioRequestDTO usuarioRequestDTO);

    void deletar(UUID id);
}