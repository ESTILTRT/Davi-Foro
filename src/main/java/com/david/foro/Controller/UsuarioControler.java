package com.david.foro.Controller;

import com.david.foro.Domain.Usuario.DTOs.DatosRegistroUsuarios;
import com.david.foro.Domain.Usuario.DTOs.DatosRetornoUsuario;
import com.david.foro.Domain.Usuario.DTOs.DatosUsuarioLogin;
import com.david.foro.Domain.Usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRetornoUsuario> registrarUsuarios(@RequestBody @Valid DatosRegistroUsuarios datos){
        return ResponseEntity.ok(service.registrarUsuario(datos));
    }

}
