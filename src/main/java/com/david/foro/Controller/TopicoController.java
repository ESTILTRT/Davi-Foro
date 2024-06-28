package com.david.foro.Controller;

import com.david.foro.Domain.Foro.DTOs.DatosDetalleTopico;
import com.david.foro.Domain.Foro.DTOs.DatosModificarTopico;
import com.david.foro.Domain.Foro.DTOs.DatosRegistroTopicos;
import com.david.foro.Domain.Foro.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foro")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Topicos",description = "Esta zona se encarga de todos los procesos relacionados con los tópicos.")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopicos datos,
                                                            UriComponentsBuilder uriComponentsBuilder){
        var respuesta = service.registrarTopicos(datos);
        URI url = uriComponentsBuilder.path("/foro/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(url).body(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> obtenerForos(@PageableDefault(sort = "fecha") Pageable paginacion,
                                                                 @RequestParam(required = false) String nombreCurso){
         var detalle = service.listadoTopicos(paginacion,nombreCurso);
        return ResponseEntity.ok(detalle);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> mostrarTopico(@PathVariable Long id){
        var respuesta = service.mostrarTopico(id);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> modificarTopico(@PathVariable Long id,
                                                              @RequestBody @Valid DatosModificarTopico datos){
        var modificado = service.modificarTopico(id,datos);
        return ResponseEntity.ok(modificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        service.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
