package com.czo.restaurantes_api.dto.restaurante;

import com.czo.restaurantes_api.dto.EnderecoDTO;
import com.czo.restaurantes_api.dto.usuario.UsuarioResponseDTO;

import java.time.LocalTime;
import java.util.UUID;

public record RestauranteResponseDTO(
        String nome,
        EnderecoDTO endereco,
        String tipoCozinha,
        LocalTime horarioAbertura,
        LocalTime horarioFechamento,
        String donoNome
) {
}
