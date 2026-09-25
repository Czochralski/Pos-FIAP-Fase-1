package com.czo.restaurantes_api.dto.itemCardapio;

import java.math.BigDecimal;

public record ItemCardapioResponseDTO(
        String nome,
        String descricao,
        BigDecimal preco,
        boolean disponivelApenasLocal,
        String caminhoFoto,
        String restauranteNome
) {
}
