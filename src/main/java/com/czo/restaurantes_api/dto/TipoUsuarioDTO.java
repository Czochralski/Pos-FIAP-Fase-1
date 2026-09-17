package com.czo.restaurantes_api.dto;

import jakarta.validation.constraints.NotBlank;

public record TipoUsuarioDTO(

        @NotBlank(message = "Campo Obrigatório")
        String nomeTipo
) {
}
