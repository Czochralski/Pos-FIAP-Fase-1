package com.czo.restaurantes_api.dto.restaurante;

import com.czo.restaurantes_api.dto.EnderecoDTO;

import java.time.LocalTime;
import java.util.UUID;

public record RestauranteRequestDTO(
        String nome,
        EnderecoDTO endereco,
        String tipoCozinha,
        LocalTime horarioAbertura,
        LocalTime horarioFechamento,
        UUID donoId
) {
}
