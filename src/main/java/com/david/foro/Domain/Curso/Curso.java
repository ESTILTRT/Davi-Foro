package com.david.foro.Domain.Curso;

import com.david.foro.Domain.Curso.DTOs.DatosRegistrarCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean disponible;

    public Curso(DatosRegistrarCurso datos) {
        this.nombre = datos.nombre();
        this.categoria = Categoria.estandarisar(datos.categoria());
        this.disponible = true;
    }
}
