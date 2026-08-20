package com.czo.restaurantes_api.dto;

import java.util.UUID;

public record UsuarioResponseCadastroDTO(
        UUID id,

        String nome,

        String email,

        String login,

        EnderecoDTO endereco
) {
}
