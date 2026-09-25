package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.restaurante.RestauranteRequestDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseCadastroDTO;
import com.czo.restaurantes_api.dto.restaurante.RestauranteResponseDTO;
import com.czo.restaurantes_api.dto.usuario.UsuarioRequestAtualizacaoDTO;
import com.czo.restaurantes_api.service.RestauranteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService service;

    @PostMapping
    public RestauranteResponseCadastroDTO salvar(@Valid @RequestBody RestauranteRequestDTO restauranteRequestDTO){

        return service.salvarRestaurante(restauranteRequestDTO);
    }

    @GetMapping
    public List<RestauranteResponseDTO> buscar(@RequestParam String nome){

        return service.buscarRestaurantes(nome);
    }

    @PutMapping("/{id}")
    public RestauranteResponseDTO atualizar(@Valid @PathVariable UUID id,
                                            @RequestBody  RestauranteRequestDTO restauranteRequestDTO) {

        return service.atualizarRestaurante(id, restauranteRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletarRestaurante(id);

        return ResponseEntity.noContent().build();
    }
}
