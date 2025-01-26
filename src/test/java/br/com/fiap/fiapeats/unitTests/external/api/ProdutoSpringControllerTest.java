package br.com.fiap.fiapeats.unitTests.external.api;

import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.external.api.ProdutoSpringController;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.external.api.mapper.ProdutoMapper;
import br.com.fiap.fiapeats.usecases.dtos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProdutoSpringControllerTest {

  @InjectMocks
  private ProdutoSpringController produtoSpringController;

  @Mock
  private ProdutoController produtoController;

  @Mock
  private ProdutoMapper produtoMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void criarProdutoComSucesso() {
    CriarProdutoRequest request = new CriarProdutoRequest();
    CriarProdutoDTO dto = new CriarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem");
    CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "nome", "descricao", BigDecimal.TEN, "categoria", "imagem");

    when(produtoMapper.toCriarProdutoDTO(request)).thenReturn(dto);
    when(produtoController.criarProduto(dto)).thenReturn(response);

    ResponseEntity<CriarProdutoResponse> result = produtoSpringController.criarProduto(request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void editarProdutoComSucesso() {
    UUID id = UUID.randomUUID();
    EditarProdutoRequest request = new EditarProdutoRequest();
    EditarProdutoDTO dto = new EditarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem", id);
    EditarProdutoResponse response = mock(EditarProdutoResponse.class);

    when(produtoMapper.toEditarProdutoDTO(id, request)).thenReturn(dto);
    when(produtoController.editarProduto(dto)).thenReturn(response);

    ResponseEntity<Object> result = produtoSpringController.editarProduto(id, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void removerProdutoComSucesso() {
    UUID id = UUID.randomUUID();

    ResponseEntity<Object> result = produtoSpringController.removerProduto(id);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

  @Test
  void listarTodosProdutosComSucesso() {
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.listarTodosProdutos()).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarTodosProdutos();

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void consultarProdutoPorCategoriaComSucesso() {
    String categoria = "Bebidas";
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.consultarProdutoPorCategoria(categoria)).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.consultarProdutoPorCategoria(categoria);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }
}