package com.czo.restaurantes_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Resposta de retorno sobre cadastrado do usuário")
public record UsuarioResponseCadastroDTO(
        UUID id,

        String nome,

        String email,

        String login,

        EnderecoDTO endereco
) {
}
