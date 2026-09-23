package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.exceptions.RegistroDuplicadoException;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import com.czo.restaurantes_api.mapper.TipoUsuarioMapper;
import com.czo.restaurantes_api.model.TipoUsuario;
import com.czo.restaurantes_api.repository.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

    private final TipoUsuarioRepository repository;

    private final TipoUsuarioMapper mapper;

    @Override
    public TipoUsuarioResponseCadastroDTO salvarTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {

        if (repository.existsByNomeTipoIgnoreCase(tipoUsuarioDTO.nomeTipo())) {
            throw new RegistroDuplicadoException("Tipo de usuário já existente na base de dados");
        }

        TipoUsuario tipoUsuario = mapper.toEntity(tipoUsuarioDTO);

        repository.save(tipoUsuario);

        return mapper.toResponseCadastro(tipoUsuario);
    }

    @Override
    public List<TipoUsuarioDTO> buscarTiposUsuarios(){

        List<TipoUsuario> tipoUsuarios = repository.findAll();

        return tipoUsuarios.stream().map(mapper::toResponse).toList();
    }

    @Override
    public void atualizarTipoUsuario(UUID id, TipoUsuarioDTO tipoUsuarioDTO) {

        TipoUsuario tipoUsuario = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Tipo de usuário não encontrado"));

        mapper.atualizar(tipoUsuario, tipoUsuarioDTO);

        repository.save(tipoUsuario);
    }

    @Override
    public void deletarTipoUsuario(UUID id) {

       TipoUsuario tipoUsuario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

       repository.delete(tipoUsuario);
    }
}
