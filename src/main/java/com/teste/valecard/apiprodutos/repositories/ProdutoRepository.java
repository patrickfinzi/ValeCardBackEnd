package com.teste.valecard.apiprodutos.repositories;

import com.teste.valecard.apiprodutos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query("select p from Produto p where p.status = 'ativo'")
    List<Produto> findByStatus();
}
