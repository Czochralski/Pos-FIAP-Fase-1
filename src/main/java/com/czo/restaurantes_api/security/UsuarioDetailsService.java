package com.czo.restaurantes_api.security;

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

        return User
                .withUsername(usuario.getLogin())
                .password(usuario.getSenha())
                .build();
    }
}
