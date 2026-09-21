package com.czo.restaurantes_api.mapper;

import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;
import com.czo.restaurantes_api.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface RestauranteMapper {

    @Mapping(source = "dono.id", target = "donoId")
    @Mapping(source = "dono.nome", target = "donoNome")
    RestauranteResponseCadastroDTO toResponseCadastro(Restaurante restaurante);

    RestauranteResponseDTO toResponse(Restaurante restaurante);

}