package com.teste.valecard.apiprodutos.services;

import com.teste.valecard.apiprodutos.dto.ProdutoDTO;
import com.teste.valecard.apiprodutos.entities.Produto;
import com.teste.valecard.apiprodutos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public String cadastrarProduto(Produto produto){
        LocalDateTime dataCadastro = LocalDateTime.now();
        produto.setDataCriacao(dataCadastro);
        produtoRepository.save(produto);
        return "Produto cadastrado com sucesso";
    }

    public String excluirProduto(Long id){
        produtoRepository.deleteById(id);
        return "Produto excluido com sucesso";
    }

    public Produto listarProduto(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public String ativarDesativarProduto(Long id){
        LocalDateTime dataAtualizacao;
        Produto produto = produtoRepository.findById(id).orElse(null);
        if(produto == null){
            return "produto não cadastrado";
        }
        if(produto.getStatus().equals("ativo")){
            produto.setStatus("não ativo");
        }
        else{
            produto.setStatus("ativo");
        }
        dataAtualizacao = LocalDateTime.now();
        produto.setDataAtualizacao(dataAtualizacao);
        produtoRepository.save(produto);
        return "produto atualizado com sucesso";
    }

    public String atualizarProduto(ProdutoDTO produtoDto){
        Produto produto = produtoRepository.findById(produtoDto.getId()).orElse(null);
        if(produto == null){
            return "produto não encontrado";
        }
        setProduto(produto,produtoDto);
        produtoRepository.save(produto);
        return "produto atualizado";
    }

    public void setProduto(Produto produto, ProdutoDTO produtoDTO){
        LocalDateTime dataAtualizacao = LocalDateTime.now();
        produto.setDataAtualizacao(dataAtualizacao);
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setNome(produtoDTO.getNome());
        produto.getCategoria().setId(produtoDTO.getId());
    }

    public List<Produto> listaAtivos(){
        return produtoRepository.findByStatus();
    }
}
