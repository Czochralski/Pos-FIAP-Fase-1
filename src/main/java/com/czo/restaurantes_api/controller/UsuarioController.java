package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.UsuarioRequestDTO;
import com.czo.restaurantes_api.dto.UsuarioResponseDTO;
import com.czo.restaurantes_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody UsuarioRequestDTO dto) {

        return service.salvar(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> buscarUsuarios(@RequestParam String nome) {

        return service.buscarUsuarios(nome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID id, @RequestBody UsuarioRequestDTO dto) {

        service.atualizarUsuarios(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarSenha(@PathVariable UUID id, @RequestBody UsuarioRequestDTO dto) {
        service.atualizarSenha(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}