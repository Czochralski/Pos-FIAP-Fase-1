package com.czo.restaurantes_api.dto;

import com.czo.restaurantes_api.model.TipoUsuario;

public record UsuarioRequestDTO(

        String nome,

        String email,

        String login,

        String senha,

        TipoUsuario tipoUsuario,

        EnderecoDTO endereco
) {
}
