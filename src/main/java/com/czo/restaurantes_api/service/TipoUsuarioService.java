package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioResponseCadastroDTO;

import java.util.List;
import java.util.UUID;

public interface TipoUsuarioService {

    TipoUsuarioResponseCadastroDTO salvarTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO);

    void atualizarTipoUsuario(UUID id, TipoUsuarioDTO tipoUsuarioDTO);

    List<TipoUsuarioDTO> buscarTiposUsuarios();

    void deletarTipoUsuario(UUID id);
}
