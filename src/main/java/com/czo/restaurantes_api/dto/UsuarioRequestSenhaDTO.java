package com.czo.restaurantes_api.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestSenhaDTO(

        @NotBlank(message = "Campo Obrigatório")
        String senha
){
}
