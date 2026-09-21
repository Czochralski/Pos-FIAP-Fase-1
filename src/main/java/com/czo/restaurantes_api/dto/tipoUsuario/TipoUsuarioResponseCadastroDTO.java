package com.czo.restaurantes_api.dto.tipoUsuario;

import java.util.UUID;

public record TipoUsuarioResponseCadastroDTO(

        UUID id,

        String nomeTipo
) {
}
