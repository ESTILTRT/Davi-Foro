package com.david.foro.Domain.Foro;

import com.david.foro.Domain.Curso.Curso;
import com.david.foro.Domain.Foro.DTOs.DatosModificarTopico;
import com.david.foro.Domain.Foro.DTOs.DatosRegistroTopicos;
import com.david.foro.Domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    private LocalDateTime fecha;
    private boolean status;

    public Topico(DatosRegistroTopicos datos, Usuario autor, Curso curso) {
        var FFecha = DateTimeFormatter.ofPattern("dd/MM/yy HH");

        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.usuario = autor;
        this.curso = curso;
        this.fecha = LocalDateTime.parse(LocalDateTime.now().format(FFecha), FFecha);
        this.status = true;
    }

    public void modificarTopico(DatosModificarTopico datos) {
        if (!datos.titulo().equals("")){
            this.titulo = datos.titulo();
        } else if (!datos.mensaje().equals("")) {
            this.mensaje = datos.mensaje();
        }
    }
}
