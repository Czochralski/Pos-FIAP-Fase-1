package com.czo.restaurantes_api.dto;

import com.czo.restaurantes_api.model.TipoUsuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Requisição de atualização do usuário")
public record UsuarioRequestAtualizacaoDTO(

        @NotBlank(message = "Campo Obrigatório")
        String nome,

        @NotBlank(message = "Campo Obrigatório")
        @Email
        String email,

        @NotBlank(message = "Campo Obrigatório")
        String login,

        @Valid
        @NotNull(message = "Campo Obrigatório")
        EnderecoDTO endereco
) {
}
