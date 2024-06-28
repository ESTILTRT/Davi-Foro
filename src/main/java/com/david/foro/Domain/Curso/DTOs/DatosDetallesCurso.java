package com.david.foro.Domain.Curso.DTOs;

import com.david.foro.Domain.Curso.Categoria;
import com.david.foro.Domain.Curso.Curso;

public record DatosDetallesCurso(
        Long id,
        String nombre,
        Categoria categoria
) {
    public DatosDetallesCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
