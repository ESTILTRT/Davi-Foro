package com.david.foro.Infra.Seguridad;

import com.david.foro.Domain.Usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UsuariosRepository repository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        return repository.findByCorreo(correo);
    }
}
