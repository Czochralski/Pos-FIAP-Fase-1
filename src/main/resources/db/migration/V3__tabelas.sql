CREATE TABLE restaurantes
(
    id                 UUID PRIMARY KEY,
    nome               VARCHAR(150) NOT NULL,
    endereco_id        UUID         NOT NULL UNIQUE,
    tipo_cozinha       VARCHAR(100) NOT NULL,
    horario_abertura   TIME         NOT NULL,
    horario_fechamento TIME         NOT NULL,
    dono_id            UUID         NOT NULL,

    CONSTRAINT fk_restaurante_endereco
        FOREIGN KEY (endereco_id)
            REFERENCES enderecos (id),

    CONSTRAINT fk_restaurante_dono
        FOREIGN KEY (dono_id)
            REFERENCES usuarios (id)
);