package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.TipoUsuarioResponseCadastroDTO;
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
    public TipoUsuarioResponseCadastroDTO salvar(TipoUsuarioDTO tipoUsuarioDTO) {

        if (repository.existsByNomeTipoIgnoreCase(tipoUsuarioDTO.nomeTipo())) {
            throw new RegistroDuplicadoException(
                    "Tipo de usuário já existente na base de dados"
            );
        }

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNomeTipo(tipoUsuarioDTO.nomeTipo());

        repository.save(tipoUsuario);
        return mapper.toResponseCadastro(tipoUsuario);
    }

    @Override
    public List<TipoUsuarioDTO> buscaTiposUsuarios(){
        List<TipoUsuario> tipoUsuarios = repository.findAll();
        return tipoUsuarios.stream().map(mapper::toResponse).toList();
    }

    @Override
    public void atualizarTiposUsuarios(UUID id, TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuario tipoUsuario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        tipoUsuario.setNomeTipo(tipoUsuarioDTO.nomeTipo());
        repository.save(tipoUsuario);
    }

    @Override
    public void deletar(UUID id) {
       TipoUsuario tipoUsuario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tipo de usuário não encontrado"));

        repository.delete(tipoUsuario);
    }
}
