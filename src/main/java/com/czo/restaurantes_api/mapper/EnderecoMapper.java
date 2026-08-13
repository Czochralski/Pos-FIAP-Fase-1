package com.czo.restaurantes_api.mapper;

import com.czo.restaurantes_api.dto.EnderecoDTO;
import com.czo.restaurantes_api.model.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEntity(EnderecoDTO dto);

}