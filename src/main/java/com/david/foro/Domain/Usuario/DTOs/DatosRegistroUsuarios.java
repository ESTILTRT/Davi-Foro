package com.david.foro.Domain.Usuario.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuarios(
        @NotBlank
        String nombreUsuario,
        @NotBlank
        @Email
        String correo,
        @NotBlank
        String clave
) {
}
