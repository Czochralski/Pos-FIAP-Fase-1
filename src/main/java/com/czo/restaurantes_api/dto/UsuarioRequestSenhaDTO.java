package com.czo.restaurantes_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "Requisição de atualização de senha do usuário")
public record UsuarioRequestSenhaDTO(

        @NotBlank(message = "Campo Obrigatório")
        String senha
){
}
