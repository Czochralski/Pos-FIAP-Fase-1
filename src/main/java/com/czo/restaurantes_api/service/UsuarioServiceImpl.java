package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.UsuarioRequestDTO;
import com.czo.restaurantes_api.dto.UsuarioResponseDTO;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import com.czo.restaurantes_api.mapper.EnderecoMapper;
import com.czo.restaurantes_api.mapper.UsuarioMapper;
import com.czo.restaurantes_api.model.Cliente;
import com.czo.restaurantes_api.model.DonoRestaurante;
import com.czo.restaurantes_api.model.TipoUsuario;
import com.czo.restaurantes_api.model.Usuario;
import com.czo.restaurantes_api.repository.UsuarioRepository;
import com.czo.restaurantes_api.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final EnderecoMapper enderecoMapper;
    private final UsuarioValidator validator;

    @Override
    public UsuarioResponseDTO salvar(UsuarioRequestDTO usuarioDTO) {

        TipoUsuario tipoUsuario = usuarioDTO.tipoUsuario();

        if (tipoUsuario == null) {
            throw new IllegalArgumentException("Tipo de usuário é obrigatório");
        }

        Usuario usuario = switch (tipoUsuario) {
            case CLIENTE -> new Cliente();
            case DONO -> new DonoRestaurante();
        };

        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        usuario.setEndereco(
                enderecoMapper.toEntity(usuarioDTO.endereco()));

        validator.validar(usuario);
        Usuario usuarioSalvo = repository.save(usuario);

        return mapper.toResponse(usuarioSalvo);
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
    public void atualizarUsuarios(UUID id, UsuarioRequestDTO usuarioDTO) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setLogin(usuarioDTO.login());
        usuario.setEndereco(
                enderecoMapper.toEntity(usuarioDTO.endereco()));

        validator.validar(usuario);
        repository.save(usuario);
    }

    @Override
    public void atualizarSenha(UUID id, UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));
        usuario.setSenha(usuarioDTO.senha());

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