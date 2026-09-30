package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.*;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import com.czo.restaurantes_api.mapper.UsuarioMapper;
import com.czo.restaurantes_api.model.Usuario;
import com.czo.restaurantes_api.repository.UsuarioRepository;
import com.czo.restaurantes_api.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final UsuarioValidator validator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseCadastroDTO salvar(UsuarioRequestCadastroDTO usuarioDTO) {

        Usuario usuario = mapper.toEntity(usuarioDTO);

        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));

        validator.validar(usuario);
        Usuario usuarioSalvo = repository.save(usuario);

        return mapper.toResponseCadastro(usuarioSalvo);
    }

    @Override
    public List<UsuarioResponseDTO> buscarUsuarios(String nome) {

        List<Usuario> usuarios =
                repository.findByNomeContainingIgnoreCase(nome);

        return usuarios.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void atualizarUsuarios(UUID id, UsuarioRequestAtualizacaoDTO usuarioDTO) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        mapper.atualizar(usuario, usuarioDTO);

        validator.validar(usuario);
        repository.save(usuario);
    }

    @Override
    public void atualizarSenha(UUID id, UsuarioRequestSenhaDTO usuarioDTO) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));

        repository.save(usuario);
    }

    @Override
    public void deletar(UUID id){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        repository.delete(usuario);
    }
}