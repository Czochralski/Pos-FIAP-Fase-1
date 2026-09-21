package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioResponseCadastroDTO;

import java.util.List;
import java.util.UUID;

public interface TipoUsuarioService {

    TipoUsuarioResponseCadastroDTO salvar(TipoUsuarioDTO tipoUsuarioDTO);

    void atualizarTiposUsuarios(UUID id, TipoUsuarioDTO tipoUsuarioDTO);

    List<TipoUsuarioDTO> buscaTiposUsuarios();

    void deletar(UUID id);
}
