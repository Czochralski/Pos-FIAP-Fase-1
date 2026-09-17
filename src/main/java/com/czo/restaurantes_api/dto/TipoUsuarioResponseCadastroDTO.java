package com.czo.restaurantes_api.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record TipoUsuarioResponseCadastroDTO(

        UUID id,

        String nomeTipo
) {
}
