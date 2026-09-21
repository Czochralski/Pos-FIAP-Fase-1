package com.czo.restaurantes_api.mapper;


import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.model.TipoUsuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoUsuarioMapper {

    TipoUsuarioDTO toResponse(TipoUsuario tipoUsuario);

    TipoUsuarioResponseCadastroDTO toResponseCadastro(TipoUsuario tipoUsuario);
}
