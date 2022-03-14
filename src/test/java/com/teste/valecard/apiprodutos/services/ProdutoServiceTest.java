package com.teste.valecard.apiprodutos.services;

import com.teste.valecard.apiprodutos.dto.ProdutoDTO;
import com.teste.valecard.apiprodutos.entities.Produto;
import com.teste.valecard.apiprodutos.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.teste.valecard.apiprodutos.utils.ProdutoUtils.createFakeEntity;
import static com.teste.valecard.apiprodutos.utils.ProdutoUtils.createFakeDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {
    @Mock
    ProdutoRepository produtoRepository;
    @InjectMocks
    ProdutoService produtoService;

    @Test
    void testGivenProdutoReturnCadastroSuccessMessage(){
        Produto expectedProduto = createFakeEntity();
        when(produtoRepository.save(any(Produto.class))).thenReturn(expectedProduto);
        String sucesso = produtoService.cadastrarProduto(expectedProduto);
        String expectedSuccessMessage = "Produto cadastrado com sucesso";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenIdReturnProduto(){
        Produto expectedProduto = createFakeEntity();
        when(produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedProduto));
        Produto sucesso = produtoService.listarProduto(1L);
        assertEquals(expectedProduto,sucesso);
    }

    @Test
    void testListarTodosProdutos(){
        List<Produto> expectedList = new ArrayList<>();
        Produto expectedProduto = createFakeEntity();
        expectedList.add(expectedProduto);
        when(produtoRepository.findAll()).thenReturn(expectedList);
        List<Produto> sucesso = produtoService.listarTodosProdutos();
        assertEquals(expectedList,sucesso);
    }

    @Test
    void testGivenIdReturnNaoAtivoSuccessMessage(){
        Produto expectedProduto = createFakeEntity();
        when(produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedProduto));
        when(produtoRepository.save(any(Produto.class))).thenReturn(expectedProduto);
        String sucesso = produtoService.ativarDesativarProduto(1L);
        String expectedSuccessMessage = "produto atualizado com sucesso";
        assertEquals("não ativo",expectedProduto.getStatus() );
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenIdReturnAtivoSuccessMessage(){
        Produto expectedProduto = createFakeEntity();
        expectedProduto.setStatus("não ativo");
        when(produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedProduto));
        when(produtoRepository.save(any(Produto.class))).thenReturn(expectedProduto);
        String sucesso = produtoService.ativarDesativarProduto(1L);
        String expectedSuccessMessage = "produto atualizado com sucesso";
        assertEquals("ativo",expectedProduto.getStatus() );
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenDTOReturnAtualizadoSuccessMessage(){
        ProdutoDTO expectedProdutoDTO = createFakeDTO();
        Produto expectedProduto = createFakeEntity();
        when(produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedProduto));
        when(produtoRepository.save(any(Produto.class))).thenReturn(expectedProduto);
        String sucesso = produtoService.atualizarProduto(expectedProdutoDTO);
        String expectedSuccessMessage = "produto atualizado";
        assertEquals(expectedSuccessMessage,sucesso);
    }
}
