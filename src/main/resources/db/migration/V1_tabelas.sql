CREATE TABLE enderecos (
                           id UUID PRIMARY KEY,
                           rua VARCHAR(150) NOT NULL,
                           numero VARCHAR(10) NOT NULL,
                           bairro VARCHAR(100) NOT NULL,
                           cidade VARCHAR(100) NOT NULL,
                           estado CHAR(2) NOT NULL,
                           cep VARCHAR(9) NOT NULL
);

CREATE TABLE usuarios (
                          id UUID PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(150) NOT NULL UNIQUE,
                          login VARCHAR(50) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          data_cadastro TIMESTAMP NOT NULL,
                          data_atualizacao TIMESTAMP NOT NULL,
                          endereco_id UUID NOT NULL UNIQUE,
                          tipo_usuario VARCHAR(20) NOT NULL

                              CONSTRAINT fk_usuario_endereco
                              FOREIGN KEY (endereco_id)
                              REFERENCES enderecos(id)
);