package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioDTO;
import com.czo.restaurantes_api.dto.tipoUsuario.TipoUsuarioResponseCadastroDTO;
import com.czo.restaurantes_api.service.TipoUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tipo-usuario")
@RequiredArgsConstructor
public class TipoUsuarioController {

    private final TipoUsuarioService service;

    @PostMapping
    public TipoUsuarioResponseCadastroDTO salvar(@RequestBody TipoUsuarioDTO dto) {
        return  service.salvarTipoUsuario(dto);
    }


    @GetMapping
    public List<TipoUsuarioDTO> buscarTiposUsuarios() {

        return service.buscarTiposUsuarios();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarTiposUsuarios(
            @PathVariable UUID id, @RequestBody TipoUsuarioDTO dto) {

        service.atualizarTipoUsuario(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletarTipoUsuario(id);

        return ResponseEntity.noContent().build();
    }

}
