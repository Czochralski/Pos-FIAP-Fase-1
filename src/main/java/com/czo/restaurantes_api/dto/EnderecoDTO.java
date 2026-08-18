package com.czo.restaurantes_api.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
        @NotBlank(message = "Campo Obrigatório")
        String rua,

        @NotBlank(message = "Campo Obrigatório")
        String numero,

        @NotBlank(message = "Campo Obrigatório")
        String bairro,

        @NotBlank(message = "Campo Obrigatório")
        String cidade,

        @NotBlank(message = "Campo Obrigatório")
        String estado,

        @NotBlank(message = "Campo Obrigatório")
        String cep
) {
}
