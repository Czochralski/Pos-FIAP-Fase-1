package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;

import java.util.List;
import java.util.UUID;


public interface RestauranteService {

    RestauranteResponseCadastroDTO salvar(RestauranteRequestDTO restauranteRequestCadastroDTO);

    List<RestauranteResponseDTO> buscar(String nome);

    void atualizar(UUID id, RestauranteRequestDTO restauranteRequestDTO);

    void deletar(UUID id);
}
