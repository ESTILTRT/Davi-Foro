package com.david.foro.Domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByCorreo(String subject);
    Boolean existsByCorreo(String correo);

    @Query("SELECT u.activo FROM Usuario u WHERE u.correo = :correo")
    Boolean findActivoByCorreo(String correo);
}
