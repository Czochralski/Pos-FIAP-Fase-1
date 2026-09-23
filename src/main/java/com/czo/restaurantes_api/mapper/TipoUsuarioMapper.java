package com.czo.restaurantes_api.mapper;


import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.model.TipoUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TipoUsuarioMapper {

    @Mapping(target = "id", ignore = true)
    TipoUsuario toEntity(TipoUsuarioDTO tipoUsuarioDTO);

    @Mapping(target = "id", ignore = true)
    void atualizar(@MappingTarget TipoUsuario tipoUsuario, TipoUsuarioDTO tipoUsuarioDTO);

    TipoUsuarioDTO toResponse(TipoUsuario tipoUsuario);

    TipoUsuarioResponseCadastroDTO toResponseCadastro(TipoUsuario tipoUsuario);
}
