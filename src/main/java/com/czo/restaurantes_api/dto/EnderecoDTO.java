package com.czo.restaurantes_api.dto;

public record EnderecoDTO(
        String rua,

        String numero,

        String bairro,

        String cidade,

        String estado,

        String cep
) {
}
