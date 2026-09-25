package com.czo.restaurantes_api.dto.itemCardapio;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemCardapioRequestDTO(
        @NotBlank(message = "Campo Obrigatório")
        String nome,
        @NotBlank(message = "Campo Obrigatório")
        String descricao,
        @NotBlank(message = "Campo Obrigatório")
        BigDecimal preco,
        @NotBlank(message = "Campo Obrigatório")
        boolean disponivelApenasLocal,

        String caminhoFoto,

        @NotBlank(message = "Campo Obrigatório")
        @Valid
        UUID restauranteId
) {
}
