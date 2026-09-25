CREATE TABLE itens_cardapio
(
    id                      UUID PRIMARY KEY,
    nome                    VARCHAR(150)   NOT NULL,
    descricao               VARCHAR(500)   NOT NULL,
    preco                   NUMERIC(10, 2) NOT NULL,
    disponivel_apenas_local BOOLEAN        NOT NULL,
    caminho_foto            VARCHAR(500),
    restaurante_id          UUID           NOT NULL,

    CONSTRAINT fk_item_cardapio_restaurante
        FOREIGN KEY (restaurante_id)
            REFERENCES restaurantes (id)
);