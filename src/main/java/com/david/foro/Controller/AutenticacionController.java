package com.david.foro.Controller;

import com.david.foro.Domain.Usuario.DTOs.DatosUsuarioLogin;
import com.david.foro.Domain.Usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid DatosUsuarioLogin datos){
        var token = service.autenticacion(datos);
        return ResponseEntity.ok(token);
    }
}
