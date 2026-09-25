package com.czo.restaurantes_api.dto.restaurante;

import com.czo.restaurantes_api.dto.EnderecoDTO;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;
import java.util.UUID;

public record RestauranteRequestDTO(
        @NotBlank(message = "Campo Obrigatório")
        String nome,
        @NotBlank(message = "Campo Obrigatório")
        EnderecoDTO endereco,
        @NotBlank(message = "Campo Obrigatório")
        String tipoCozinha,
        @NotBlank(message = "Campo Obrigatório")
        LocalTime horarioAbertura,
        @NotBlank(message = "Campo Obrigatório")
        LocalTime horarioFechamento,
        @NotBlank(message = "Campo Obrigatório")
        UUID donoId
) {
}
