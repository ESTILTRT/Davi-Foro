package com.david.foro.Domain.Foro.ReglasDeNegocio;

import com.david.foro.Domain.Foro.DTOs.DatosRegistroTopicos;

public interface Reglas {
    void validar(DatosRegistroTopicos datos);
}
