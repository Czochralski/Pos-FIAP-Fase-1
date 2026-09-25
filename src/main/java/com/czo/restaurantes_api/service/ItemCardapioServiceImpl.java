package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioRequestDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseCadastroDTO;
import com.czo.restaurantes_api.dto.itemCardapio.ItemCardapioResponseDTO;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import com.czo.restaurantes_api.mapper.ItemCardapioMapper;
import com.czo.restaurantes_api.model.ItemCardapio;
import com.czo.restaurantes_api.model.Restaurante;
import com.czo.restaurantes_api.repository.ItemCardapioRepository;
import com.czo.restaurantes_api.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemCardapioServiceImpl implements ItemCardapioService {

    private final ItemCardapioRepository repository;
    private final RestauranteRepository restauranteRepository;
    private final ItemCardapioMapper mapper;

    @Override
    public ItemCardapioResponseCadastroDTO salvarItemCardapio(ItemCardapioRequestDTO itemCardapioRequestDTO) {

        Restaurante restaurante = restauranteRepository.findById(itemCardapioRequestDTO.restauranteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Restaurante não encontrado"));

        ItemCardapio item = mapper.toEntity(itemCardapioRequestDTO);

        item.setRestaurante(restaurante);

        ItemCardapio itemSalvo = repository.save(item);

        return mapper.toResponseCadastro(itemSalvo);
    }

    @Override
    public List<ItemCardapioResponseDTO> listarItensCardapio(String nome) {
        List<ItemCardapio> itensCardapios = repository.findByNomeContainingIgnoreCase(nome);

        return itensCardapios.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ItemCardapioResponseDTO atualizarItemCardapio(UUID id, ItemCardapioRequestDTO itemCardapioRequestDTO) {

        ItemCardapio item = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item do cardápio não encontrado"));

        restauranteRepository.findById(itemCardapioRequestDTO.restauranteId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurante não encontrado"));

        mapper.atualizar(item, itemCardapioRequestDTO);

        ItemCardapio itemAtualizado = repository.save(item);

        return mapper.toResponse(itemAtualizado);
    }

    @Override
    public void excluirItemCardapio(UUID id) {

        ItemCardapio item = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item do cardápio não encontrado"));

        repository.delete(item);
    }
}