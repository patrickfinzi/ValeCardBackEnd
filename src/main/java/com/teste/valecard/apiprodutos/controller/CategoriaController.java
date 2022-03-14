package com.teste.valecard.apiprodutos.controller;

import com.teste.valecard.apiprodutos.entities.Categoria;
import com.teste.valecard.apiprodutos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @CrossOrigin
    @PostMapping(value = "/criarCategoria", produces = MediaType.TEXT_PLAIN_VALUE)
    public String criarCategoria(@RequestBody Categoria categoria){
        return categoriaService.criarCategoria(categoria);
    }

    @GetMapping("/listarCategoria/{id}")
    public Categoria listarCategoria(@PathVariable Long id){
        return categoriaService.listarCategoria(id);
    }

    @CrossOrigin
    @GetMapping("/listarTodasCategorias")
    public List<Categoria> listarTodasCategorias(){
        return categoriaService.listarTodasCategorias();
    }

    @CrossOrigin
    @DeleteMapping("/deletarCategoria/{id}")
    public String deletarCategoria(@PathVariable Long id){
        return categoriaService.deletarCategoria(id);
    }

    @CrossOrigin
    @PutMapping("/atualizarCategoria/{id}")
    public String atualizarCategoria(@PathVariable Long id, @RequestBody String nome){
        return categoriaService.atualizarCategoria(id, nome);
    }
}
