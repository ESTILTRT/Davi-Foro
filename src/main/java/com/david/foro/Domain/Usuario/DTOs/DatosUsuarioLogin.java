package com.david.foro.Domain.Usuario.DTOs;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuarioLogin(
        @NotBlank
        String correo,
        @NotBlank
        String clave) {
}
