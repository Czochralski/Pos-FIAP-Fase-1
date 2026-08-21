package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.*;
import com.czo.restaurantes_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuários")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @Operation(summary = "Salvar", description = "Cadastrar novo usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro de validação."),
            @ApiResponse(responseCode = "409", description = "Recurso em duplicidade.")
    })
    public UsuarioResponseCadastroDTO salvar(@Valid @RequestBody UsuarioRequestCadastroDTO dto) {

        return service.salvar(dto);
    }

    @GetMapping
    @Operation(summary = "Buscar Usuários", description = "Realiza pesquisa de usuários pelo parametro nome.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sucesso."),
            @ApiResponse(responseCode = "401", description = "Não autenticado ou credenciais inválidas.")
    })
    public List<UsuarioResponseDTO> buscarUsuarios(@RequestParam String nome) {

        return service.buscarUsuarios(nome);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um usuário existente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "400", description = "Erro de validação."),
            @ApiResponse(responseCode = "401", description = "Não autenticado ou credenciais inválidas.")
    })
    public ResponseEntity<Void> atualizar(@PathVariable UUID id, @Valid @RequestBody UsuarioRequestAtualizacaoDTO dto) {

        service.atualizarUsuarios(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/senha")
    @Operation(summary = "Atualizar senha", description = "Atualiza senha de um usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "400", description = "Erro de validação."),
            @ApiResponse(responseCode = "401", description = "Não autenticado ou credenciais inválidas.")
    })
    public ResponseEntity<Void> atualizarSenha(@PathVariable UUID id, @Valid @RequestBody UsuarioRequestSenhaDTO dto) {

        service.atualizarSenha(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Deleta um usuário existente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "401", description = "Não autenticado ou credenciais inválidas.")
    })
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}