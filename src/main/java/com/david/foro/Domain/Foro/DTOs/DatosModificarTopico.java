package com.david.foro.Domain.Foro.DTOs;

import jakarta.validation.constraints.NotNull;

public record DatosModificarTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje
) {
}
