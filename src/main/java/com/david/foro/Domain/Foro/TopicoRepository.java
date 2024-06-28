package com.david.foro.Domain.Foro;

import com.david.foro.Domain.Foro.DTOs.DatosDetalleTopico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("SELECT CASE WHEN COUNT(t.titulo) > 0 THEN true ELSE false END  " +
            "FROM Topico t " +
            "WHERE t.titulo = :titulo")
    boolean existsByTitulo(String titulo);

    @Query("SELECT CASE WHEN COUNT(t.mensaje) > 0 THEN true ELSE false END  " +
            "FROM Topico t " +
            "WHERE t.mensaje = :mensaje")
    boolean existsByMensaje(String mensaje);

    @Query("SELECT t FROM Topico t JOIN t.curso c WHERE c.nombre ILIKE %:nombreCurso%")
    Page<Topico> findByCursoContainsIgnoreCase(String nombreCurso, Pageable paginacion);
}
