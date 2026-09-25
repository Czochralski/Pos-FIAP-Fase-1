package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioRequestDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ItemCardapioService {

    ItemCardapioResponseCadastroDTO salvarItemCardapio(ItemCardapioRequestDTO dto);

    List<ItemCardapioResponseDTO> listarItensCardapio(String nome);

    ItemCardapioResponseDTO atualizarItemCardapio(UUID id, ItemCardapioRequestDTO dto
    );

    void excluirItemCardapio(UUID id);
}
