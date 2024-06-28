package com.david.foro.Domain.Curso;

import com.david.foro.Domain.Curso.DTOs.DatosDetallesCurso;
import com.david.foro.Domain.Curso.DTOs.DatosRegistrarCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;


    public DatosDetallesCurso registrarCurso(DatosRegistrarCurso datos) {
        var curso = repository.save(new Curso(datos));
        return new DatosDetallesCurso(curso);
    }
}
