package com.czo.restaurantes_api.dto;

import com.czo.restaurantes_api.model.TipoUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(

        @NotBlank(message = "Campo Obrigatório")
        String nome,

        @NotBlank(message = "Campo Obrigatório")
        @Email
        String email,

        @NotBlank(message = "Campo Obrigatório")
        String login,

        @NotBlank(message = "Campo Obrigatório")
        String senha,

        @NotNull(message = "Campo Obrigatório")
        TipoUsuario tipoUsuario,

        @Valid
        @NotNull(message = "Campo Obrigatório")
        EnderecoDTO endereco
) {
}
