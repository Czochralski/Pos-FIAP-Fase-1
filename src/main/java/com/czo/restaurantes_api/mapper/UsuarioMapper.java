package com.czo.restaurantes_api.mapper;

import com.czo.restaurantes_api.dto.UsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.UsuarioResponseDTO;
import com.czo.restaurantes_api.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO toResponse(Usuario usuario);

    UsuarioResponseCadastroDTO toResponseCadastro(Usuario usuario);
}