package com.david.foro.Domain.Curso.DTOs;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
