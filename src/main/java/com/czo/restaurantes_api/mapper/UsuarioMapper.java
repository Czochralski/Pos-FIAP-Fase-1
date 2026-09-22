package com.czo.restaurantes_api.mapper;

import com.czo.restaurantes_api.dto.usuario.UsuarioRequestAtualizacaoDTO;
import com.czo.restaurantes_api.dto.usuario.UsuarioRequestCadastroDTO;
import com.czo.restaurantes_api.dto.usuario.UsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.usuario.UsuarioResponseDTO;
import com.czo.restaurantes_api.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    Usuario toEntity(UsuarioRequestCadastroDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    void atualizar(@MappingTarget Usuario usuario, UsuarioRequestAtualizacaoDTO dto);

    UsuarioResponseDTO toResponse(Usuario usuario);

    UsuarioResponseCadastroDTO toResponseCadastro(Usuario usuario);
}