package com.david.foro.Domain.Foro.DTOs;

import com.david.foro.Domain.Foro.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String nombreAutor,
        String nombreCurso,
        LocalDateTime fecha
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getUsuario().getNombreUsuario(),
                topico.getCurso().getNombre(), topico.getFecha());
    }
}
