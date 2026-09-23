package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;

import java.util.List;
import java.util.UUID;


public interface RestauranteService {

    RestauranteResponseCadastroDTO salvarRestaurante(RestauranteRequestDTO restauranteRequestCadastroDTO);

    List<RestauranteResponseDTO> buscarRestaurantes(String nome);

    RestauranteResponseDTO atualizarRestaurante(UUID id, RestauranteRequestDTO restauranteRequestDTO);

    void deletarRestaurante(UUID id);
}
