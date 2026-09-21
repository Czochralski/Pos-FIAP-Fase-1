package com.czo.restaurantes_api.repository;

import com.czo.restaurantes_api.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {
    List<Restaurante> findByNomeContainingIgnoreCase(String nome);
}
