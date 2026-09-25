package com.czo.restaurantes_api.mapper;

import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioRequestDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;
import com.czo.restaurantes_api.model.ItemCardapio;
import com.czo.restaurantes_api.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ItemCardapioMapper {


    @Mapping(target = "id", ignore = true)
    ItemCardapio toEntity(ItemCardapioRequestDTO itemCardapioRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "restaurante",ignore = true)
    void atualizar(@MappingTarget ItemCardapio itemCardapio, ItemCardapioRequestDTO itemCardapioRequestDTO);

    @Mapping(source = "restaurante.id", target = "restauranteId")
    ItemCardapioResponseCadastroDTO toResponseCadastro(ItemCardapio itemCardapio);

    @Mapping(source = "restaurante.nome", target = "restauranteNome")
    ItemCardapioResponseDTO toResponse(ItemCardapio itemCardapio);
}
