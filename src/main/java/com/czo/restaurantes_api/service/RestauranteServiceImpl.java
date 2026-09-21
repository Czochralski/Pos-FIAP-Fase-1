package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import com.czo.restaurantes_api.mapper.EnderecoMapper;
import com.czo.restaurantes_api.mapper.RestauranteMapper;
import com.czo.restaurantes_api.mapper.UsuarioMapper;
import com.czo.restaurantes_api.model.Restaurante;
import com.czo.restaurantes_api.model.Usuario;
import com.czo.restaurantes_api.repository.RestauranteRepository;
import com.czo.restaurantes_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements RestauranteService{

    private final RestauranteRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final EnderecoMapper enderecoMapper;
    private final UsuarioMapper usuarioMapper;
    private final RestauranteMapper mapper;

    @Override
    public RestauranteResponseCadastroDTO salvar(RestauranteRequestDTO dto){

        Usuario dono = usuarioRepository.findById(dto.donoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        Restaurante restaurante = new Restaurante();

        restaurante.setNome(dto.nome());
        restaurante.setEndereco(
                enderecoMapper.toEntity(dto.endereco())
        );
        restaurante.setTipoCozinha(dto.tipoCozinha());
        restaurante.setHorarioAbertura(dto.horarioAbertura());
        restaurante.setHorarioFechamento(dto.horarioFechamento());
        restaurante.setDono(dono);

        Restaurante restauranteSalvo =
                repository.save(restaurante);

        return mapper.toResponseCadastro(restauranteSalvo);
    }

    @Override
    public List<RestauranteResponseDTO> buscar(String nome){
        List<Restaurante> restaurantes =
                repository.findByNomeContainingIgnoreCase(nome);

        return restaurantes.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void atualizar(UUID id, RestauranteRequestDTO restauranteRequestDTO) {
        Restaurante restaurante = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado"));

        restaurante.setNome(restauranteRequestDTO.nome());
        restaurante.setEndereco(
                enderecoMapper.toEntity(restauranteRequestDTO.endereco()));
        restaurante.setTipoCozinha(restauranteRequestDTO.tipoCozinha());
        restaurante.setHorarioAbertura(restauranteRequestDTO.horarioAbertura());
        restaurante.setHorarioFechamento(restauranteRequestDTO.horarioFechamento());

        repository.save(restaurante);
    }

    @Override
    public void deletar(UUID id){
        Restaurante restaurante = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Restaurante não encontrado"));

        repository.delete(restaurante);
    }
}
