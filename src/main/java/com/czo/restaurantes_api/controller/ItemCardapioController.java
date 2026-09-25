package com.czo.restaurantes_api.controller;

import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioRequestDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseDTO;
import com.czo.restaurantes_api.service.ItemCardapioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/itens-cardapio")
@RequiredArgsConstructor
public class ItemCardapioController {

    private final ItemCardapioService service;

    @PostMapping
    public ItemCardapioResponseCadastroDTO salvarItemCardapio(@RequestBody ItemCardapioRequestDTO dto){
        return service.salvarItemCardapio(dto);
    }

    @GetMapping
    public List<ItemCardapioResponseDTO> listarItensCardapio(@RequestParam String nome){
        return service.listarItensCardapio(nome);
    }

    @PutMapping("/{id}")
    public ItemCardapioResponseDTO atualizarItemCardapio(@PathVariable UUID id,
                                                         @RequestBody ItemCardapioRequestDTO dto) {
        return service.atualizarItemCardapio(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluirItemCardapio(@PathVariable UUID id) {
        service.excluirItemCardapio(id);
    }
}
