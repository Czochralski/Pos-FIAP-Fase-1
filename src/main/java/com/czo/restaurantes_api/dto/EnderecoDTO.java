package com.czo.restaurantes_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "Endereço")
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
