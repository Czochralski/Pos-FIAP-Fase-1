package com.czo.restaurantes_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Resposta de retorno sobre consulta ao usuário")
public record UsuarioResponseDTO(
        String nome,

        String email,

        String login,

        EnderecoDTO endereco
) {
}
