package com.czo.restaurantes_api.validator;

import com.czo.restaurantes_api.exceptions.RegistroDuplicadoException;
import com.czo.restaurantes_api.model.Usuario;
import com.czo.restaurantes_api.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioValidator {

    private final UsuarioRepository repository;

    public UsuarioValidator(UsuarioRepository repository){
        this.repository = repository;
    }

    public void validar(Usuario usuario){
        if(verificarEmailCadastrado(usuario)){
            throw new RegistroDuplicadoException("Email já cadastrado");
        }
        if(verificarLoginCadastrado(usuario)){
            throw new RegistroDuplicadoException("Login já cadastrado");
        }
    }

    private boolean verificarEmailCadastrado(Usuario usuario){
        Optional<Usuario> usuarioEncontrado = repository.findByEmailIgnoreCase(
                usuario.getEmail());

        //Verificando se já existe este email no momento do cadastro
        if(usuario.getId() == null){
            return usuarioEncontrado.isPresent() ;
        }

        //Verificando se email ja existe
        //Retornando true se o id passando é diferente do id do objeto buscado no banco.
        return usuarioEncontrado.filter(value -> !usuario.getId().equals(value.getId())).isPresent();
    }

    public boolean verificarLoginCadastrado(Usuario usuario){
        Optional<Usuario> usuarioEncontrado = repository.findByLoginIgnoreCase(
                usuario.getLogin());

        //Verificando se já existe este login no momento do cadastro
        if(usuario.getId() == null){
            return usuarioEncontrado.isPresent() ;
        }

        //Verificando se login ja existe
        //Retornando true se o id passado é diferente do id do objeto buscado no banco.
        return usuarioEncontrado.filter(value -> !usuario.getId().equals(value.getId())).isPresent();
    }
}
