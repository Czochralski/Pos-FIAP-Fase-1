package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.usuario.*;
import com.czo.restaurantes_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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
    @Operation(
            summary = "Salvar",
            description = "Cadastrar novo usuário"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cadastrado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Cadastro realizado com sucesso",
                                    value = """
                                            {
                                              "id": "bc915976-3239-4bbc-a912-5eb15ae9a6af",
                                              "nome": "Bruno Miranda",
                                              "email": "bruno@email.com",
                                              "login": "bruno",
                                              "endereco": {
                                                "rua": "Rua das Flores",
                                                "numero": 100,
                                                "bairro": "Centro",
                                                "cidade": "São Paulo",
                                                "estado": "SP",
                                                "cep": "01000-000"
                                              }
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Campos inválidos",
                                    value = """
                                            {
                                              "detail": "Existem campos inválidos na requisição",
                                              "instance": "/v1/usuarios",
                                              "status": 400,
                                              "title": "Erro de validação",
                                              "errors": {
                                                "senha": "Campo Obrigatório",
                                                "endereco.rua": "Campo Obrigatório",
                                                "endereco.bairro": "Campo Obrigatório"
                                              }
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Recurso em duplicidade.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "E-mail duplicado",
                                            value = """
                                                    {
                                                      "detail": "E-mail já cadastrado",
                                                      "instance": "/v1/usuarios",
                                                      "status": 409,
                                                      "title": "Recurso em duplicidade"
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Login duplicado",
                                            value = """
                                                    {
                                                      "detail": "Login já cadastrado",
                                                      "instance": "/v1/usuarios",
                                                      "status": 409,
                                                      "title": "Recurso em duplicidade"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
    })
    public UsuarioResponseCadastroDTO salvar(
            @Valid @RequestBody UsuarioRequestCadastroDTO dto) {

        return service.salvar(dto);
    }

    @GetMapping
    @Operation(
            summary = "Buscar Usuários",
            description = "Realiza pesquisa de usuários pelo parametro nome."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Usuários encontrados",
                                    value = """
                                            [
                                              {
                                                "id": "bc915976-3239-4bbc-a912-5eb15ae9a6af",
                                                "nome": "Bruno Miranda",
                                                "email": "bruno@email.com",
                                                "login": "bruno",
                                                "endereco": {
                                                  "rua": "Rua das Flores",
                                                  "numero": 100,
                                                  "bairro": "Centro",
                                                  "cidade": "São Paulo",
                                                  "estado": "SP",
                                                  "cep": "01000-000"
                                                }
                                              }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autenticado ou credenciais inválidas.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Credenciais inválidas",
                                    value = """
                                            {
                                              "status": 401,
                                              "error": "Unauthorized"
                                            }
                                            """
                            )
                    )
            )
    })
    public List<UsuarioResponseDTO> buscarUsuarios(
            @RequestParam String nome) {

        return service.buscarUsuarios(nome);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar",
            description = "Atualiza um usuário existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Atualizado com sucesso. Nenhum conteúdo é retornado."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Campos inválidos",
                                    value = """
                                            {
                                              "detail": "Existem campos inválidos na requisição",
                                              "instance": "/v1/usuarios/bc915976-3239-4bbc-a912-5eb15ae9a6af",
                                              "status": 400,
                                              "title": "Erro de validação",
                                              "errors": {
                                                "nome": "Campo Obrigatório"
                                              }
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Usuário inexistente",
                                    value = """
                                            {
                                              "detail": "Usuário não encontrado",
                                              "instance": "/v1/usuarios/bc915976-3239-4bbc-a912-5eb15ae9a6af",
                                              "status": 404,
                                              "title": "Usuário não encontrado"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autenticado ou credenciais inválidas.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Credenciais inválidas",
                                    value = """
                                            {
                                              "status": 401,
                                              "error": "Unauthorized"
                                            }
                                            """
                            )
                    )
            )
    })
    public ResponseEntity<Void> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody UsuarioRequestAtualizacaoDTO dto) {

        service.atualizarUsuarios(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/senha")
    @Operation(
            summary = "Atualizar senha",
            description = "Atualiza senha de um usuário"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Senha atualizada com sucesso. Nenhum conteúdo é retornado."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Usuário inexistente",
                                    value = """
                                            {
                                              "detail": "Usuário não encontrado",
                                              "instance": "/v1/usuarios/bc915976-3239-4bbc-a912-5eb15ae9a6af/senha",
                                              "status": 404,
                                              "title": "Usuário não encontrado"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Senha inválida",
                                    value = """
                                            {
                                              "detail": "Existem campos inválidos na requisição",
                                              "instance": "/v1/usuarios/bc915976-3239-4bbc-a912-5eb15ae9a6af/senha",
                                              "status": 400,
                                              "title": "Erro de validação",
                                              "errors": {
                                                "senha": "Campo Obrigatório"
                                              }
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autenticado ou credenciais inválidas.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Credenciais inválidas",
                                    value = """
                                            {
                                              "status": 401,
                                              "error": "Unauthorized"
                                            }
                                            """
                            )
                    )
            )
    })
    public ResponseEntity<Void> atualizarSenha(
            @PathVariable UUID id,
            @Valid @RequestBody UsuarioRequestSenhaDTO dto) {

        service.atualizarSenha(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar",
            description = "Deleta um usuário existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Deletado com sucesso. Nenhum conteúdo é retornado."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Usuário inexistente",
                                    value = """
                                            {
                                              "detail": "Usuário não encontrado",
                                              "instance": "/v1/usuarios/bc915976-3239-4bbc-a912-5eb15ae9a6af",
                                              "status": 404,
                                              "title": "Usuário não encontrado"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autenticado ou credenciais inválidas.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Credenciais inválidas",
                                    value = """
                                            {
                                              "status": 401,
                                              "error": "Unauthorized"
                                            }
                                            """
                            )
                    )
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}