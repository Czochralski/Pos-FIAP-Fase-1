package com.czo.restaurantes_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "itens_cardapio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "disponivel_apenas_local", nullable = false)
    private boolean disponivelApenasLocal;

    @Column(name = "caminho_foto", length = 500)
    private String caminhoFoto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;
}