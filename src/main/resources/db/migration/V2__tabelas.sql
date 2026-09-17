CREATE TABLE tipo_usuarios (
                               id UUID PRIMARY KEY,
                               nome_tipo VARCHAR(50) NOT NULL UNIQUE
);

ALTER TABLE usuarios
DROP COLUMN tipo_usuario;

ALTER TABLE usuarios
    ADD COLUMN tipo_usuario_id UUID NOT NULL;

ALTER TABLE usuarios
    ADD CONSTRAINT fk_usuario_tipo
        FOREIGN KEY (tipo_usuario_id)
            REFERENCES tipo_usuarios(id);