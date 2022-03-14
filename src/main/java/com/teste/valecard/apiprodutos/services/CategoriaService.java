package com.teste.valecard.apiprodutos.services;

import com.teste.valecard.apiprodutos.entities.Categoria;
import com.teste.valecard.apiprodutos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public String criarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
        return "Categoria criada com sucesso.";
    }

    public Categoria listarCategoria(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        return categoria;
    }

    public List<Categoria> listarTodasCategorias(){
        return categoriaRepository.findAll();
    }

    public String deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
        return "Categoria deletada com sucesso";
    }

    public String atualizarCategoria(Long id, String nome){
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if(categoria == null){
            return "Categoria não foi encontrada";
        }
        categoria.setNome(nome);
        categoriaRepository.save(categoria);
        return "Categoria atualizada com sucesso.";
    }
}
