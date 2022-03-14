package com.teste.valecard.apiprodutos.utils;

import com.teste.valecard.apiprodutos.dto.ProdutoDTO;
import com.teste.valecard.apiprodutos.entities.Produto;

import java.time.LocalDateTime;

public class ProdutoUtils {
    private static final Long id = 1L;
    private static final String nome = "sabao";
    private static final String descricao = "sabao barra";
    private static final LocalDateTime dataCriacao = LocalDateTime.now();
    private static final LocalDateTime dataAtualizacao = LocalDateTime.now();
    private static final String status = "ativo";

    public static Produto createFakeEntity(){
        return Produto.builder().id(id)
                .nome(nome)
                .descricao(descricao)
                .dataCriacao(dataCriacao)
                .dataAtualizacao(dataAtualizacao)
                .status(status)
                .categoria(CategoriaUtils.createFakeEntity())
                .build();
    }

    public static ProdutoDTO createFakeDTO(){
        return ProdutoDTO.builder().id(id)
                .nome(nome)
                .descricao(descricao)
                .idCategoria(1)
                .build();
    }
}
