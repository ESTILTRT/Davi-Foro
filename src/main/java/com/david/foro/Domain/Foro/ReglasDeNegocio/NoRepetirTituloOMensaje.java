package com.david.foro.Domain.Foro.ReglasDeNegocio;

import com.david.foro.Domain.Foro.DTOs.DatosRegistroTopicos;
import com.david.foro.Domain.Foro.TopicoRepository;
import com.david.foro.Infra.Errors.Excepciones.ReglasException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoRepetirTituloOMensaje implements Reglas{
    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DatosRegistroTopicos datos) {
        var titulo = repository.existsByTitulo(datos.titulo());
        if (titulo){
            throw new ReglasException("El titulo que colocaste ya existe...");
        }
        var mensaje = repository.existsByMensaje(datos.mensaje());
        if (mensaje){
            throw new ReglasException("El mensaje que escribiste es exactamente igual a otro ya escrito...");
        }
    }
}
