package com.teste.valecard.apiprodutos.utils;

import com.teste.valecard.apiprodutos.entities.Categoria;

public class CategoriaUtils {
    private static final Long id = 1L;
    private static final String nome = "limpeza";

    public static Categoria createFakeEntity(){
        return Categoria.builder().id(id)
                .nome(nome)
                .build();
    }
}
