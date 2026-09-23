package com.czo.restaurantes_api.mapper;

import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;
import com.czo.restaurantes_api.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface RestauranteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dono",ignore = true)
    Restaurante toEntity(RestauranteRequestDTO restauranteRequestDTO);

    @Mapping(target = "id", ignore = true)
    void atualizar(@MappingTarget Restaurante restaurante, RestauranteRequestDTO restauranteRequestDTO);

    @Mapping(source = "dono.id", target = "donoId")
    @Mapping(source = "dono.nome", target = "donoNome")
    RestauranteResponseCadastroDTO toResponseCadastro(Restaurante restaurante);

    @Mapping(source = "dono.nome", target = "donoNome")
    RestauranteResponseDTO toResponse(Restaurante restaurante);

}