package com.david.foro.Domain.Usuario.DTOs;

import com.david.foro.Domain.Usuario.Usuario;

public record DatosRetornoUsuario(Long id, String nombre, String correo) {

    public DatosRetornoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombreUsuario(), usuario.getCorreo());
    }
}
