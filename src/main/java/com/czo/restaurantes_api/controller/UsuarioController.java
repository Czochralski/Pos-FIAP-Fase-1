package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.*;
import com.czo.restaurantes_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public UsuarioResponseCadastroDTO salvar(@Valid @RequestBody UsuarioRequestCadastroDTO dto) {

        return service.salvar(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> buscarUsuarios(@RequestParam String nome) {

        return service.buscarUsuarios(nome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID id, @Valid @RequestBody UsuarioRequestAtualizacaoDTO dto) {

        service.atualizarUsuarios(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/senha")
    public ResponseEntity<Void> atualizarSenha(@PathVariable UUID id, @Valid @RequestBody UsuarioRequestSenhaDTO dto) {
        service.atualizarSenha(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}