package com.czo.restaurantes_api.service;

import com.czo.restaurantes_api.dto.UsuarioRequestCadastroDTO;
import com.czo.restaurantes_api.model.Cliente;
import com.czo.restaurantes_api.model.DonoRestaurante;
import com.czo.restaurantes_api.model.Usuario;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFactory {

    @ObjectFactory
    public Usuario criar(UsuarioRequestCadastroDTO dto) {

        return switch (dto.tipoUsuario()) {
            case CLIENTE -> new Cliente();
            case DONO -> new DonoRestaurante();
        };
    }
}
