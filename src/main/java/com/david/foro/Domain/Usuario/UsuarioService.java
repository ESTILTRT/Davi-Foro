package com.david.foro.Domain.Usuario;

import com.david.foro.Domain.Usuario.DTOs.DatosRegistroUsuarios;
import com.david.foro.Domain.Usuario.DTOs.DatosRetornoUsuario;
import com.david.foro.Domain.Usuario.DTOs.DatosUsuarioLogin;
import com.david.foro.Infra.Seguridad.TokenService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService  tokenService;

    public DatosRetornoUsuario registrarUsuario(DatosRegistroUsuarios datos){
        var calveEncriptada = BCrypt.hashpw(datos.clave(), BCrypt.gensalt());
        Usuario usuario = new Usuario(datos,calveEncriptada);
        repository.save(usuario);
        return new DatosRetornoUsuario(usuario);
    }

    public String autenticacion(DatosUsuarioLogin datos) {
        var existeCorreo = repository.existsByCorreo(datos.correo());
        if (!existeCorreo){
            throw new ValidationException("El correo solicitado no se encontro");
        }
        var usuarioActivo = repository.findActivoByCorreo(datos.correo());
        if (!usuarioActivo){
            throw new ValidationException("El usuario no esta activo");
        }

        Authentication autenticationToken = new UsernamePasswordAuthenticationToken(datos.correo(),
                datos.clave());
        var usuarioAutenticado = authenticationManager.authenticate(autenticationToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return JWTtoken;
    }
}
