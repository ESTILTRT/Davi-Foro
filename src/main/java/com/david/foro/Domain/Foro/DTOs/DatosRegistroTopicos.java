package com.david.foro.Domain.Foro.DTOs;

import com.david.foro.Domain.Curso.Curso;
import com.david.foro.Domain.Usuario.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long usuario,
        @NotNull
        Long curso
) {
}
