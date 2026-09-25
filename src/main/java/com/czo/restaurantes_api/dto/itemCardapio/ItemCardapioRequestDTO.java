package com.czo.restaurantes_api.dto.itemCardapio;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemCardapioRequestDTO(
        @NotBlank(message = "Campo Obrigatório")
        String nome,

        @NotBlank(message = "Campo Obrigatório")
        String descricao,

        @NotNull(message = "Campo Obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal preco,

        boolean disponivelApenasLocal,

        @Size(max = 500, message = "O caminho da foto deve possuir no máximo 500 caracteres")
        String caminhoFoto,

        @NotBlank(message = "Campo Obrigatório")
        UUID restauranteId
) {
}
