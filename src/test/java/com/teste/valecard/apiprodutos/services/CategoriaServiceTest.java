package com.teste.valecard.apiprodutos.services;

import com.teste.valecard.apiprodutos.entities.Categoria;
import com.teste.valecard.apiprodutos.repositories.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.teste.valecard.apiprodutos.utils.CategoriaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {
    @Mock
    private CategoriaRepository categoriaRepository;
    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    void testGivenCategoriaReturnCadastroSuccessMessage(){
        Categoria expectedCategoria = createFakeEntity();
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(expectedCategoria);
        String sucesso = categoriaService.criarCategoria(expectedCategoria);
        String expectedSuccessMessage = "Categoria criada com sucesso.";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenIdReturnListaCategoria(){
        Categoria expectedCategoria = createFakeEntity();
        when(categoriaRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedCategoria));
        Categoria sucesso = categoriaService.listarCategoria(1L);
        assertEquals(expectedCategoria,sucesso);
    }

    @Test
    void testListarTodasCategorias(){
        List<Categoria> expectedList = new ArrayList<>();
        Categoria expectedCategoria = createFakeEntity();
        expectedList.add(expectedCategoria);
        when(categoriaRepository.findAll()).thenReturn(expectedList);
        List<Categoria> sucesso = categoriaService.listarTodasCategorias();
        assertEquals(expectedList,sucesso);
    }

    @Test
    void testGivenIdReturnDeleteSuccessMessage(){
        String sucesso = categoriaService.deletarCategoria(1L);
        String expectedSuccessMessage = "Categoria deletada com sucesso";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenIdReturnAtualizaSuccessMessage(){
        Categoria expectedCategoria = createFakeEntity();
        when(categoriaRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedCategoria));
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(expectedCategoria);
        String sucesso = categoriaService.atualizarCategoria(1L, "alimento");
        String expectedSuccessMessage = "Categoria atualizada com sucesso.";
        assertEquals(expectedSuccessMessage,sucesso);
    }

    @Test
    void testGivenIdReturnNullMessage(){
        String sucesso = categoriaService.atualizarCategoria(2L, "alimento");
        String expectedSuccessMessage = "Categoria não foi encontrada";
        assertEquals(expectedSuccessMessage,sucesso);
    }
}
