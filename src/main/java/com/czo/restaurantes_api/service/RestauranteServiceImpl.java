package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import com.czo.restaurantes_api.mapper.RestauranteMapper;
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

    private final RestauranteMapper mapper;

    @Override
    public RestauranteResponseCadastroDTO salvarRestaurante(RestauranteRequestDTO restauranteRequestDTO){

        Usuario dono = usuarioRepository.findById(restauranteRequestDTO.donoId()).orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        Restaurante restaurante = mapper.toEntity(restauranteRequestDTO);

        restaurante.setDono(dono);

        Restaurante restauranteSalvo = repository.save(restaurante);

        return mapper.toResponseCadastro(restauranteSalvo);
    }

    @Override
    public List<RestauranteResponseDTO> buscarRestaurantes(String nome){

        List<Restaurante> restaurantes = repository.findByNomeContainingIgnoreCase(nome);

        return restaurantes.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public RestauranteResponseDTO atualizarRestaurante(UUID id,
                                                       RestauranteRequestDTO restauranteRequestDTO) {

        Restaurante restaurante = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado"));

        Usuario dono = usuarioRepository.findById(restauranteRequestDTO.donoId()).orElseThrow(() ->
                new ResourceNotFoundException("Usuário não encontrado"));

        mapper.atualizar(restaurante,restauranteRequestDTO);

        restaurante.setDono(dono);

        Restaurante restauranteAtualizado = repository.save(restaurante);

        return mapper.toResponse(restauranteAtualizado);
    }

    @Override
    public void deletarRestaurante(UUID id){

        Restaurante restaurante = repository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Restaurante não encontrado"));

        repository.delete(restaurante);
    }
}
