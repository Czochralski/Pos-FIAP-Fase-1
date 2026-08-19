package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.UsuarioRequestAtualizacaoDTO;
import com.czo.restaurantes_api.dto.UsuarioRequestCadastroDTO;
import com.czo.restaurantes_api.dto.UsuarioRequestSenhaDTO;
import com.czo.restaurantes_api.dto.UsuarioResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    UsuarioResponseDTO salvar(UsuarioRequestCadastroDTO usuarioRequestCadastroDTO);

    List<UsuarioResponseDTO> buscarUsuarios(String nome);

    void atualizarUsuarios(UUID id, UsuarioRequestAtualizacaoDTO UsuarioRequestAtualizacaoDTO);

    void atualizarSenha(UUID id, UsuarioRequestSenhaDTO usuarioRequestSenhaDTO);

    void deletar(UUID id);
}