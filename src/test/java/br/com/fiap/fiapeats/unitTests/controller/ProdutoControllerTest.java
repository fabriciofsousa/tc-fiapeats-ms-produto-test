package br.com.fiap.fiapeats.unitTests.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.*;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

class ProdutoControllerTest {

  @InjectMocks
  private ProdutoController produtoController;

  @Mock
  private CriarProdutoUseCase criarProdutoUseCase;

  @Mock
  private EditarProdutoUseCase editarProdutoUseCase;

  @Mock
  private ExcluirProdutoUseCase excluirProdutoUseCase;

  @Mock
  private ListarProdutosUseCase listarProdutosUseCase;

  @Mock
  private ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase;

  @Mock
  private ListarProdutosPorListaDeIdsUseCase listarProdutosPorListaDeIdsUseCase;

  private Produto produto;
  private Categoria categoria;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    Random random = new Random();
    categoria = new Categoria(random.nextLong(), "Categoria Teste");
    produto = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), categoria, null);
  }

  @Test
  void deveCriarProdutoComSucesso() {
    CriarProdutoDTO criarProdutoDTO = new CriarProdutoDTO("Produto Teste", "Descrição", new BigDecimal("10.0"), "Categoria Teste", null);
    when(criarProdutoUseCase.criar(criarProdutoDTO)).thenReturn(produto);

    CriarProdutoResponse resultado = produtoController.criarProduto(criarProdutoDTO);

    assertThat(resultado).isNotNull();
    assertThat(resultado.getNome()).isEqualTo("Produto Teste");
    verify(criarProdutoUseCase, times(1)).criar(criarProdutoDTO);
  }

  @Test
  void deveFalharAoCriarProdutoNulo() {
    when(criarProdutoUseCase.criar(null)).thenThrow(new IllegalArgumentException("Produto inválido"));

    try {
      produtoController.criarProduto(null);
    } catch (Exception e) {
      assertThat(e).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("Produto inválido");
    }
  }

  @Test
  void deveEditarProdutoComSucesso() {
    EditarProdutoDTO editarProdutoDTO = new EditarProdutoDTO("Produto Teste", "Descrição", new BigDecimal("10.0"), "Categoria Teste", null, produto.getId());
    when(editarProdutoUseCase.editar(editarProdutoDTO)).thenReturn(produto);

    EditarProdutoResponse resultado = produtoController.editarProduto(editarProdutoDTO);

    assertThat(resultado).isNotNull();
    assertThat(resultado.getDescricao()).isEqualTo("Descrição");
    verify(editarProdutoUseCase, times(1)).editar(editarProdutoDTO);
  }

  @Test
  void deveFalharAoEditarProdutoInexistente() {
    EditarProdutoDTO editarProdutoDTO = new EditarProdutoDTO("Produto Teste", "Descrição", new BigDecimal("10.0"), "Categoria Teste", null, produto.getId());
    when(editarProdutoUseCase.editar(editarProdutoDTO)).thenThrow(new RuntimeException("Produto não encontrado"));

    try {
      produtoController.editarProduto(editarProdutoDTO);
    } catch (Exception e) {
      assertThat(e).isInstanceOf(RuntimeException.class)
              .hasMessageContaining("Produto não encontrado");
    }
  }

  @Test
  void deveExcluirProdutoComSucesso() {
    UUID produtoId = produto.getId();

    doNothing().when(excluirProdutoUseCase).excluir(produtoId);

    produtoController.removerProduto(produtoId);

    verify(excluirProdutoUseCase, times(1)).excluir(produtoId);
  }

  @Test
  void deveFalharAoExcluirProdutoInexistente() {
    UUID produtoId = UUID.randomUUID();

    doThrow(new RuntimeException("Produto não encontrado")).when(excluirProdutoUseCase).excluir(produtoId);

    try {
      produtoController.removerProduto(produtoId);
    } catch (Exception e) {
      assertThat(e).isInstanceOf(RuntimeException.class)
              .hasMessageContaining("Produto não encontrado");
    }
  }

  @Test
  void deveListarProdutosComSucesso() {
    List<Produto> listaProdutos = Arrays.asList(produto, new Produto(UUID.randomUUID(), "Outro Produto", "Desc", new BigDecimal("20.0"), categoria, null));
    when(listarProdutosUseCase.listarProdutos()).thenReturn(listaProdutos);

    List<ProdutoResponse> resultado = produtoController.listarTodosProdutos();

    assertThat(resultado).isNotEmpty().hasSize(2);
    verify(listarProdutosUseCase, times(1)).listarProdutos();
  }

  @Test
  void deveRetornarListaVaziaQuandoNaoHaProdutos() {
    when(listarProdutosUseCase.listarProdutos()).thenReturn(Arrays.asList());

    List<ProdutoResponse> resultado = produtoController.listarTodosProdutos();

    assertThat(resultado).isEmpty();
    verify(listarProdutosUseCase, times(1)).listarProdutos();
  }

  @Test
  void deveListarProdutosPorCategoriaComSucesso() {
    String categoriaId = "categoria1";
    List<Produto> listaProdutos = Arrays.asList(produto, new Produto(UUID.randomUUID(), "Outro Produto", "Desc", new BigDecimal("20.0"), categoria, null));
    when(listarProdutosPorCategoriaUseCase.listarProdutosPorCategoria(categoriaId)).thenReturn(listaProdutos);

    List<ProdutoResponse> resultado = produtoController.consultarProdutoPorCategoria(categoriaId);

    assertThat(resultado).isNotEmpty().hasSize(2);
    verify(listarProdutosPorCategoriaUseCase, times(1)).listarProdutosPorCategoria(categoriaId);
  }

  @Test
  void deveRetornarListaVaziaQuandoNaoHaProdutosNaCategoria() {
    String categoriaId = "categoria1";
    when(listarProdutosPorCategoriaUseCase.listarProdutosPorCategoria(categoriaId)).thenReturn(Arrays.asList());

    List<ProdutoResponse> resultado = produtoController.consultarProdutoPorCategoria(categoriaId);

    assertThat(resultado).isEmpty();
    verify(listarProdutosPorCategoriaUseCase, times(1)).listarProdutosPorCategoria(categoriaId);
  }

  @Test
  void deveListarProdutosPorListaDeIdsComSucesso() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());
    List<Produto> listaProdutos = Arrays.asList(produto, new Produto(UUID.randomUUID(), "Outro Produto", "Desc", new BigDecimal("20.0"), categoria, null));
    when(listarProdutosPorListaDeIdsUseCase.ListarProdutosPorListaDeIdsUseCase(uuids)).thenReturn(listaProdutos);

    List<ProdutoResponse> resultado = produtoController.listarProdutosPorListaDeIds(uuids);

    assertThat(resultado).isNotEmpty().hasSize(2);
    verify(listarProdutosPorListaDeIdsUseCase, times(1)).ListarProdutosPorListaDeIdsUseCase(uuids);
  }

  @Test
  void deveRetornarListaVaziaQuandoNaoHaProdutosParaOsIds() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());
    when(listarProdutosPorListaDeIdsUseCase.ListarProdutosPorListaDeIdsUseCase(uuids)).thenReturn(Arrays.asList());

    List<ProdutoResponse> resultado = produtoController.listarProdutosPorListaDeIds(uuids);

    assertThat(resultado).isEmpty();
    verify(listarProdutosPorListaDeIdsUseCase, times(1)).ListarProdutosPorListaDeIdsUseCase(uuids);
  }

  @Test
  void deveFalharAoListarProdutosComListaDeIdsNula() {
    when(listarProdutosPorListaDeIdsUseCase.ListarProdutosPorListaDeIdsUseCase(null)).thenThrow(new IllegalArgumentException("Lista de UUIDs inválida"));

    try {
      produtoController.listarProdutosPorListaDeIds(null);
    } catch (Exception e) {
      assertThat(e).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("Lista de UUIDs inválida");
    }
  }
}