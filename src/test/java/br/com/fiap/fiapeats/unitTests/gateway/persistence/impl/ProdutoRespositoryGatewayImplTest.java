package br.com.fiap.fiapeats.unitTests.gateway.persistence.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.ProdutoRespositoryGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class ProdutoRespositoryGatewayImplTest {

    @InjectMocks
    private ProdutoRespositoryGatewayImpl produtoRespositoryGateway;

    @Mock
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        produto = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), null, null);
    }

    @Test
    void deveSalvarProdutoComSucesso() {
        when(produtoRepository.salvar(produto)).thenReturn(produto);

        Produto resultado = produtoRespositoryGateway.salvar(produto);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getNome()).isEqualTo("Produto Teste");
        verify(produtoRepository, times(1)).salvar(produto);
    }

    @Test
    void deveEditarProdutoComSucesso() {
        when(produtoRepository.editar(produto)).thenReturn(produto);

        Produto resultado = produtoRespositoryGateway.editar(produto);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getDescricao()).isEqualTo("Descrição");
        verify(produtoRepository, times(1)).editar(produto);
    }

    @Test
    void deveConsultarProdutoPorIdComSucesso() {
        UUID produtoId = produto.getId();
        when(produtoRepository.consultarPorId(produtoId)).thenReturn(produto);

        Produto resultado = produtoRespositoryGateway.consultarPorId(produtoId);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(produtoId);
        verify(produtoRepository, times(1)).consultarPorId(produtoId);
    }

    @Test
    void deveRetornarNuloQuandoProdutoNaoEncontradoPorId() {
        UUID produtoId = UUID.randomUUID();
        when(produtoRepository.consultarPorId(produtoId)).thenReturn(null);

        Produto resultado = produtoRespositoryGateway.consultarPorId(produtoId);

        assertThat(resultado).isNull();
        verify(produtoRepository, times(1)).consultarPorId(produtoId);
    }

    @Test
    void deveExcluirProdutoComSucesso() {
        UUID produtoId = produto.getId();
        doNothing().when(produtoRepository).excluir(produtoId);

        produtoRespositoryGateway.excluir(produtoId);

        verify(produtoRepository, times(1)).excluir(produtoId);
    }

    @Test
    void deveListarProdutosComSucesso() {
        List<Produto> listaProdutos = Arrays.asList(produto, new Produto(UUID.randomUUID(), "Outro Produto", "Desc", new BigDecimal("20.0"), null, null));
        when(produtoRepository.listarProdutos()).thenReturn(listaProdutos);

        List<Produto> resultado = produtoRespositoryGateway.listarProdutos();

        assertThat(resultado).isNotEmpty().hasSize(2);
        verify(produtoRepository, times(1)).listarProdutos();
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaProdutos() {
        when(produtoRepository.listarProdutos()).thenReturn(Arrays.asList());

        List<Produto> resultado = produtoRespositoryGateway.listarProdutos();

        assertThat(resultado).isEmpty();
        verify(produtoRepository, times(1)).listarProdutos();
    }

    @Test
    void deveListarProdutosPorCategoriaComSucesso() {
        Long categoriaId = 1L;
        List<Produto> listaProdutos = Arrays.asList(produto, new Produto(UUID.randomUUID(), "Outro Produto", "Desc", new BigDecimal("20.0"), null, null));
        when(produtoRepository.listarProdutosPorcategoria(categoriaId)).thenReturn(listaProdutos);

        List<Produto> resultado = produtoRespositoryGateway.listarProdutosPorCategoria(categoriaId);

        assertThat(resultado).isNotEmpty().hasSize(2);
        verify(produtoRepository, times(1)).listarProdutosPorcategoria(categoriaId);
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaProdutosNaCategoria() {
        Long categoriaId = 1L;
        when(produtoRepository.listarProdutosPorcategoria(categoriaId)).thenReturn(Arrays.asList());

        List<Produto> resultado = produtoRespositoryGateway.listarProdutosPorCategoria(categoriaId);

        assertThat(resultado).isEmpty();
        verify(produtoRepository, times(1)).listarProdutosPorcategoria(categoriaId);
    }
}