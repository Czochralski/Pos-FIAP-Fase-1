package com.czo.restaurantes_api.dto.usuario;

import com.czo.restaurantes_api.dto.EnderecoDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Resposta de retorno sobre cadastrado do usuário")
public record UsuarioResponseCadastroDTO(
        UUID id,

        String nome,

        String email,

        String login,

        EnderecoDTO endereco,

        TipoUsuarioDTO tipoUsuario
) {
}
