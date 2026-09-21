package com.czo.restaurantes_api.dto.usuario;

import com.czo.restaurantes_api.dto.EnderecoDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Requisição de cadastro do usuário")
public record UsuarioRequestCadastroDTO(

        @NotBlank(message = "Campo Obrigatório")
        String nome,

        @NotBlank(message = "Campo Obrigatório")
        @Email
        String email,

        @NotBlank(message = "Campo Obrigatório")
        String login,

        @NotBlank(message = "Campo Obrigatório")
        String senha,

        @Valid
        @NotNull(message = "Campo Obrigatório")
        EnderecoDTO endereco,

        @Valid
        @NotNull(message = "Campo Obrigatório")
        TipoUsuarioDTO tipoUsuario
) {
}
