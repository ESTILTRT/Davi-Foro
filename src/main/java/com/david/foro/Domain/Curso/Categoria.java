package com.david.foro.Domain.Curso;

import jakarta.validation.ValidationException;

public enum Categoria {
    BACKEND("BACKEND"),
    FRONTEND("FRONTEND"),
    BASEDATOS("BASEDEDATOS"),
    CIBERSEGURIDAD("CIBERSEGURIDAD");

    private String categoria;

    Categoria(String categoria){
        this.categoria = categoria;
    }

    public static Categoria estandarisar(String texto) {
        for (Categoria categoria : Categoria.values()){
            if (categoria.categoria.equalsIgnoreCase(texto)) {
                return categoria;
            }
        }
        throw new ValidationException("La Categoria nombrada no existe");
    }
}
