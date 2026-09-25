package com.czo.restaurantes_api.dto.itemCardapio;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemCardapioResponseCadastroDTO(
        UUID id,
        String nome,
        String descricao,
        BigDecimal preco,
        boolean disponivelApenasLocal,
        String caminhoFoto,
        UUID restauranteId
) {
}
