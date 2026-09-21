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
    public RestauranteResponseCadastroDTO salvar(@RequestBody RestauranteRequestDTO restauranteRequestDTO){
        return service.salvar(restauranteRequestDTO);
    }

    @GetMapping
    public List<RestauranteResponseDTO> buscar(@RequestParam String nome){
        return service.buscar(nome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable UUID id,
            @RequestBody  RestauranteRequestDTO restauranteRequestDTO) {

        service.atualizar(id, restauranteRequestDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
