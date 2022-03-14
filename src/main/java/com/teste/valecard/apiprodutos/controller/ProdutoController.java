package com.teste.valecard.apiprodutos.controller;

import com.teste.valecard.apiprodutos.dto.ProdutoDTO;
import com.teste.valecard.apiprodutos.entities.Produto;
import com.teste.valecard.apiprodutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @CrossOrigin
    @PostMapping("/cadastrarProduto")
    public String cadastrarProduto(@RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);
    }

    @CrossOrigin
    @DeleteMapping("/excluirProduto/{id}")
    public String excluirProduto(@PathVariable Long id){
        return produtoService.excluirProduto(id);
    }

    @GetMapping("/listarProduto/{id}")
    public Produto listarProduto(@PathVariable Long id){
        return produtoService.listarProduto(id);
    }

    @CrossOrigin
    @GetMapping("/listarTodosProdutos")
    public List<Produto> listarTodosProdutos(){
        return produtoService.listarTodosProdutos();
    }

    @CrossOrigin
    @PutMapping("/ativarDesativarProduto/{id}")
    public String ativarDesativarProduto(@PathVariable Long id){
        return produtoService.ativarDesativarProduto(id);
    }

    @CrossOrigin
    @PutMapping("/atualizarProduto")
    public String atualizarProduto(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.atualizarProduto(produtoDTO);
    }

    @CrossOrigin
    @GetMapping("/listaAtivos")
    public List<Produto> listaAtivos(){
        return produtoService.listaAtivos();
    }

}
