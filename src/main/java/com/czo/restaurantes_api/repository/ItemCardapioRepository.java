package com.czo.restaurantes_api.repository;

import com.czo.restaurantes_api.model.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, UUID> {
    List<ItemCardapio> findByNomeContainingIgnoreCase(String nome);
}
