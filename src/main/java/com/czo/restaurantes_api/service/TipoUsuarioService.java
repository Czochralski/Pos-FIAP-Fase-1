package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.TipoUsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.UsuarioResponseDTO;
import com.czo.restaurantes_api.model.TipoUsuario;

import java.util.List;
import java.util.UUID;

public interface TipoUsuarioService {

    TipoUsuarioResponseCadastroDTO salvar(TipoUsuarioDTO tipoUsuarioDTO);

    void atualizarTiposUsuarios(UUID id, TipoUsuarioDTO tipoUsuarioDTO);

    List<TipoUsuarioDTO> buscaTiposUsuarios();

    void deletar(UUID id);
}
