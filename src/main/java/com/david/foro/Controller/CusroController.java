package com.david.foro.Controller;

import com.david.foro.Domain.Curso.CursoService;
import com.david.foro.Domain.Curso.DTOs.DatosRegistrarCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso")
public class CusroController {
    @Autowired
    private CursoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearCurso(@RequestBody @Valid DatosRegistrarCurso datos,
                                     UriComponentsBuilder uriComponentsBuilder){
        var cursoNuevo = service.registrarCurso(datos);
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(cursoNuevo.id()).toUri();
        return ResponseEntity.created(url).body(cursoNuevo);
    }
}
