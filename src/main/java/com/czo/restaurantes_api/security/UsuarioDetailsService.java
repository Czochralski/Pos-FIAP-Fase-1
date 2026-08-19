package com.czo.restaurantes_api.security;

import com.czo.restaurantes_api.model.Cliente;
import com.czo.restaurantes_api.model.DonoRestaurante;
import com.czo.restaurantes_api.model.Usuario;
import com.czo.restaurantes_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        Usuario usuario = repository.findByLoginIgnoreCase(login)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));

        String role;

        if (usuario instanceof Cliente) {
            role = "CLIENTE";
        } else if (usuario instanceof DonoRestaurante) {
            role = "DONO";
        } else {
            throw new IllegalArgumentException("Tipo de usuário inválido");
        }

        return User
                .withUsername(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(role)
                .build();
    }
}
