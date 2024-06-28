package com.david.foro.Controller;

import com.david.foro.Domain.Usuario.DTOs.DatosUsuarioLogin;
import com.david.foro.Domain.Usuario.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Autenticación", description = "Aquí se optiene el token para poder acceder a los demás controller.")
public class AutenticacionController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid DatosUsuarioLogin datos){
        var token = service.autenticacion(datos);
        return ResponseEntity.ok(token);
    }
}
