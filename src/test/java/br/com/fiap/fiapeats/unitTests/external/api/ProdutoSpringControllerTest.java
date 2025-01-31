package br.com.fiap.fiapeats.unitTests.external.api;

import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.domain.utils.Constants;
import br.com.fiap.fiapeats.external.api.ProdutoSpringController;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.external.api.mapper.ProdutoMapper;
import br.com.fiap.fiapeats.usecases.dtos.*;
import org.apache.logging.log4j.ThreadContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProdutoSpringControllerTest {

  @InjectMocks
  private ProdutoSpringController produtoSpringController;

  @Mock
  private ProdutoController produtoController;

  @Mock
  private ProdutoMapper produtoMapper;

  @BeforeEach
  void setUp() {
    try{
      MockitoAnnotations.openMocks(this);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void criarProdutoComSucesso() {
    CriarProdutoRequest request = new CriarProdutoRequest();
    CriarProdutoDTO dto = new CriarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem");
    CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "nome", "descricao", BigDecimal.TEN, "categoria", "imagem");

    when(produtoMapper.toCriarProdutoDTO(request)).thenReturn(dto);
    when(produtoController.criarProduto(dto)).thenReturn(response);

    ResponseEntity<CriarProdutoResponse> result = produtoSpringController.criarProduto(null, request);

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

    ResponseEntity<Object> result = produtoSpringController.editarProduto(null, id, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void removerProdutoComSucesso() {
    UUID id = UUID.randomUUID();

    ResponseEntity<Object> result = produtoSpringController.removerProduto(null, id);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

  @Test
  void listarTodosProdutosComSucesso() {
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.listarTodosProdutos()).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarTodosProdutos(null);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void consultarProdutoPorCategoriaComSucesso() {
    String categoria = "Bebidas";
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.consultarProdutoPorCategoria(categoria)).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.consultarProdutoPorCategoria(null, categoria);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void listarProdutosPorListaDeIdsComSucesso() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.listarProdutosPorListaDeIds(uuids)).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarProdutosPorListaDeIds(null, uuids);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
  }

  @Test
  void listarProdutosPorListaDeIdsRetornaNotFoundQuandoListaVazia() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());

    when(produtoController.listarProdutosPorListaDeIds(uuids)).thenReturn(List.of());

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarProdutosPorListaDeIds(null, uuids);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  void listarProdutosPorListaDeIdsRetornaNotFoundQuandoListaNula() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());

    when(produtoController.listarProdutosPorListaDeIds(uuids)).thenReturn(null);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarProdutosPorListaDeIds(null, uuids);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  void listarProdutosPorListaDeIdsComListaDeIdsVazia() {
    List<UUID> uuids = List.of();

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarProdutosPorListaDeIds(null, uuids);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  void criarProdutoComCorrelationId() {
    String correlationId = UUID.randomUUID().toString();
    CriarProdutoRequest request = new CriarProdutoRequest();
    CriarProdutoDTO dto = new CriarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem");
    CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "nome", "descricao", BigDecimal.TEN, "categoria", "imagem");

    when(produtoMapper.toCriarProdutoDTO(request)).thenReturn(dto);
    when(produtoController.criarProduto(dto)).thenReturn(response);

    ResponseEntity<CriarProdutoResponse> result = produtoSpringController.criarProduto(correlationId, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void criarProdutoSemCorrelationIdNoBody() {
    CriarProdutoRequest request = new CriarProdutoRequest();
    CriarProdutoDTO dto = new CriarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem");
    CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "nome", "descricao", BigDecimal.TEN, "categoria", "imagem");

    when(produtoMapper.toCriarProdutoDTO(request)).thenReturn(dto);
    when(produtoController.criarProduto(dto)).thenReturn(response);

    ResponseEntity<CriarProdutoResponse> result = produtoSpringController.criarProduto(null, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }
  @Test
  void criarProdutoComCorrelationIdInRequest() {
    String correlationId = UUID.randomUUID().toString();
    CriarProdutoRequest request = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");
    CriarProdutoDTO dto = new CriarProdutoDTO("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");
    CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");

    when(produtoMapper.toCriarProdutoDTO(request)).thenReturn(dto);
    when(produtoController.criarProduto(dto)).thenReturn(response);

    ResponseEntity<CriarProdutoResponse> result = produtoSpringController.criarProduto(correlationId, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void criarProdutoSemCorrelationId() {
    CriarProdutoRequest request = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");
    CriarProdutoDTO dto = new CriarProdutoDTO("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");
    CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");

    when(produtoMapper.toCriarProdutoDTO(request)).thenReturn(dto);
    when(produtoController.criarProduto(dto)).thenReturn(response);

    ResponseEntity<CriarProdutoResponse> result = produtoSpringController.criarProduto(null, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }

  @Test
  void editarProdutoComCorrelationId() {
    String correlationId = UUID.randomUUID().toString();
    UUID id = UUID.randomUUID();
    EditarProdutoRequest request = new EditarProdutoRequest("Refrigerante Atualizado", "Lata 500ml", new BigDecimal("6.99"), "Drink", "http://imagem.com/updated.png");
    EditarProdutoDTO dto = new EditarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem", id);

    when(produtoMapper.toEditarProdutoDTO(id, request)).thenReturn(dto);
    when(produtoController.editarProduto(dto)).thenReturn(null);

    ResponseEntity<Object> result = produtoSpringController.editarProduto(correlationId, id, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void editarProdutoSemCorrelationId() {
    UUID id = UUID.randomUUID();
    EditarProdutoRequest request = new EditarProdutoRequest("Refrigerante Atualizado", "Lata 500ml", new BigDecimal("6.99"), "Drink", "http://imagem.com/updated.png");
    EditarProdutoDTO dto = new EditarProdutoDTO("nome", "descricao", BigDecimal.TEN, "categoria", "imagem", id);

    when(produtoMapper.toEditarProdutoDTO(id, request)).thenReturn(dto);
    when(produtoController.editarProduto(dto)).thenReturn(null);

    ResponseEntity<Object> result = produtoSpringController.editarProduto(null, id, request);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }

  @Test
  void removerProdutoComCorrelationId() {
    String correlationId = UUID.randomUUID().toString();
    UUID id = UUID.randomUUID();

    doNothing().when(produtoController).removerProduto(id);

    ResponseEntity<Object> result = produtoSpringController.removerProduto(correlationId, id);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void removerProdutoSemCorrelationId() {
    UUID id = UUID.randomUUID();

    doNothing().when(produtoController).removerProduto(id);

    ResponseEntity<Object> result = produtoSpringController.removerProduto(null, id);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }

  @Test
  void listarTodosProdutosComCorrelationId() {
    String correlationId = UUID.randomUUID().toString();

    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.listarTodosProdutos()).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarTodosProdutos(correlationId);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void listarTodosProdutosSemCorrelationId() {
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.listarTodosProdutos()).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarTodosProdutos(null);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }

  @Test
  void consultarProdutoPorCategoriaComCorrelationId() {
    String correlationId = UUID.randomUUID().toString();
    String categoria = "Drink";
    List<ProdutoResponse> response = List.of(new ProdutoResponse());

    when(produtoController.consultarProdutoPorCategoria(categoria)).thenReturn(response);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.consultarProdutoPorCategoria(correlationId, categoria);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(response);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void consultarProdutoPorCategoriaSemCorrelationId() {
    String categoria = "Drink";
    List<ProdutoResponse> produtos = List.of(new ProdutoResponse());

    when(produtoController.consultarProdutoPorCategoria(categoria)).thenReturn(produtos);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.consultarProdutoPorCategoria(null, categoria);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(produtos);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }

  @Test
  void listarProdutosPorListaDeIdsComCorrelationId() {
    String correlationId = UUID.randomUUID().toString();
    List<UUID> uuids = List.of(UUID.randomUUID(), UUID.randomUUID());
    List<ProdutoResponse> produtos = List.of(new ProdutoResponse());

    when(produtoController.listarProdutosPorListaDeIds(uuids)).thenReturn(produtos);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarProdutosPorListaDeIds(correlationId, uuids);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(produtos);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isEqualTo(correlationId);
  }

  @Test
  void listarProdutosPorListaDeIdsSemCorrelationId() {
    List<UUID> uuids = List.of(UUID.randomUUID(), UUID.randomUUID());
    List<ProdutoResponse> produtos = List.of(new ProdutoResponse());

    when(produtoController.listarProdutosPorListaDeIds(uuids)).thenReturn(produtos);

    ResponseEntity<List<ProdutoResponse>> result = produtoSpringController.listarProdutosPorListaDeIds(null, uuids);

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(produtos);
    assertThat(ThreadContext.get(Constants.CORRELATION_ID)).isNotNull();
  }

}