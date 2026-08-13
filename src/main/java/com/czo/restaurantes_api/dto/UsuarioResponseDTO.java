package com.czo.restaurantes_api.dto;

public record UsuarioResponseDTO(
        String nome,

        String email,

        String login,

        EnderecoDTO endereco
) {
}
