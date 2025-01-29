package br.com.fiap.fiapeats.unitTests.external.persistence.impl;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.external.api.mapper.CategoriaMapper;
import br.com.fiap.fiapeats.external.persistence.impl.ProdutoRepositoryImpl;
import br.com.fiap.fiapeats.external.persistence.mapper.ProdutoEntityMapper;
import br.com.fiap.fiapeats.external.persistence.orm.ProdutoEntity;
import br.com.fiap.fiapeats.external.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class ProdutoRepositoryImplTest {

  @InjectMocks
  private ProdutoRepositoryImpl produtoRepositoryImpl;

  @Mock
  private ProdutoRepositoryJPA produtoRepositoryJPA;

  @Mock
  private ProdutoEntityMapper produtoEntityMapper;

  @Mock
  private CategoriaMapper categoriaMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void salvarProdutoComSucesso() {
    Produto produto = new Produto(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, null, "imagem1.jpg");
    ProdutoEntity produtoEntity = new ProdutoEntity();
    when(produtoEntityMapper.toProdutoEntity(produto)).thenReturn(produtoEntity);
    when(produtoRepositoryJPA.save(produtoEntity)).thenReturn(produtoEntity);
    when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

    Produto result = produtoRepositoryImpl.salvar(produto);

    assertThat(result).isEqualTo(produto);
  }

  @Test
  void editarProdutoComSucesso() {
    Produto produto = new Produto(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, null, "imagem1.jpg");
    ProdutoEntity produtoEntity = new ProdutoEntity();
    when(produtoEntityMapper.toProdutoEntity(produto)).thenReturn(produtoEntity);
    when(produtoRepositoryJPA.save(produtoEntity)).thenReturn(produtoEntity);
    when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

    Produto result = produtoRepositoryImpl.editar(produto);

    assertThat(result).isEqualTo(produto);
  }

  @Test
  void consultarProdutoPorIdExistente() {
    UUID id = UUID.randomUUID();
    Produto produto = new Produto(id, "Produto 1", "Descrição 1", BigDecimal.TEN, null, "imagem1.jpg");
    ProdutoEntity produtoEntity = new ProdutoEntity();
    when(produtoRepositoryJPA.findById(id)).thenReturn(Optional.of(produtoEntity));
    when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

    Produto result = produtoRepositoryImpl.consultarPorId(id);

    assertThat(result).isEqualTo(produto);
  }

  @Test
  void consultarProdutoPorIdInexistente() {
    UUID id = UUID.randomUUID();
    when(produtoRepositoryJPA.findById(id)).thenReturn(Optional.empty());

    Produto result = produtoRepositoryImpl.consultarPorId(id);

    assertThat(result).isNull();
  }

  @Test
  void excluirProdutoComSucesso() {
    UUID id = UUID.randomUUID();

    produtoRepositoryImpl.excluir(id);

    assertThat(produtoRepositoryJPA.findById(id)).isEmpty();
  }

  @Test
  void listarProdutosPorCategoriaExistente() {
    // Arrange
    Long idCategoria = 1L;
    UUID produtoId = UUID.randomUUID();
    ProdutoEntity produtoEntity = new ProdutoEntity();
    produtoEntity.setId(produtoId);
    produtoEntity.setNome("Produto 1");
    produtoEntity.setDescricao("Descrição 1");
    produtoEntity.setValor(BigDecimal.TEN);
    produtoEntity.setImagemUrl("imagem1.jpg");

    Produto produto = new Produto(produtoId, "Produto 1", "Descrição 1", BigDecimal.TEN, null, "imagem1.jpg");

    when(produtoRepositoryJPA.findProductByCategoryId(idCategoria)).thenReturn(List.of(produtoEntity));
    when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

    // Act
    List<Produto> result = produtoRepositoryImpl.listarProdutosPorcategoria(idCategoria);

    // Assert
    assertThat(result).hasSize(1);
    assertThat(result.get(0).getId()).isEqualTo(produtoId);
    assertThat(result.get(0).getNome()).isEqualTo("Produto 1");
    assertThat(result.get(0).getDescricao()).isEqualTo("Descrição 1");
    assertThat(result.get(0).getValor()).isEqualTo(BigDecimal.TEN);
    assertThat(result.get(0).getImagemUrl()).isEqualTo("imagem1.jpg");
  }

  @Test
  void listarProdutosPorCategoriaInexistente() {
    Long idCategoria = 1L;
    when(produtoRepositoryJPA.findProductByCategoryId(idCategoria)).thenReturn(List.of());

    assertThatThrownBy(() -> produtoRepositoryImpl.listarProdutosPorcategoria(idCategoria))
            .isInstanceOf(NotFoundException.class)
            .hasMessage("Não foram encontrados produtos!");
  }

  @Test
  void listarTodosProdutosComSucesso() {
    // Arrange
    UUID produtoId = UUID.randomUUID();
    ProdutoEntity produtoEntity = new ProdutoEntity();
    produtoEntity.setId(produtoId);
    produtoEntity.setNome("Produto 1");
    produtoEntity.setDescricao("Descrição 1");
    produtoEntity.setValor(BigDecimal.TEN);
    produtoEntity.setImagemUrl("imagem1.jpg");

    Produto produto = new Produto(produtoId, "Produto 1", "Descrição 1", BigDecimal.TEN, null, "imagem1.jpg");

    when(produtoRepositoryJPA.findAll()).thenReturn(List.of(produtoEntity));
    when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

    // Act
    List<Produto> result = produtoRepositoryImpl.listarProdutos();

    // Assert
    assertThat(result).hasSize(1);
    assertThat(result.get(0).getId()).isEqualTo(produtoId);
    assertThat(result.get(0).getNome()).isEqualTo("Produto 1");
    assertThat(result.get(0).getDescricao()).isEqualTo("Descrição 1");
    assertThat(result.get(0).getValor()).isEqualTo(BigDecimal.TEN);
    assertThat(result.get(0).getImagemUrl()).isEqualTo("imagem1.jpg");
  }

  @Test
  void listarTodosProdutosInexistentes() {
    when(produtoRepositoryJPA.findAll()).thenReturn(List.of());

    assertThatThrownBy(() -> produtoRepositoryImpl.listarProdutos())
            .isInstanceOf(NotFoundException.class)
            .hasMessage("Não foram encontrados produtos!");
  }

  @Test
  void testEqualsWithSameObject() {
    Produto produto = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), new Categoria(1L, "Categoria Teste"), "imagemUrl");
    assertThat(produto).isEqualTo(produto);
  }

  @Test
  void testEqualsWithDifferentObjectSameValues() {
    UUID id = UUID.fromString("a35d465c-2795-410e-a3df-29009eb63f70");
    Categoria categoria =  new Categoria(1L, "Categoria Teste");
    BigDecimal valor = new BigDecimal("10.0");

    Produto produto1 = new Produto(id, "Produto Teste", "Descrição", valor, categoria, "imagemUrl");
    Produto produto2 = new Produto(id, "Produto Teste", "Descrição", valor, categoria, "imagemUrl");
    assertThat(produto1).isEqualTo(produto2);
  }

  @Test
  void testNotEqualsWithDifferentValues() {
    Produto produto1 = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), new Categoria(1L, "Categoria Teste"), "imagemUrl");
    Produto produto2 = new Produto(UUID.randomUUID(), "Outro Produto", "Outra Descrição", new BigDecimal("20.0"), new Categoria(2L, "Outra Categoria"), "outraImagemUrl");
    assertThat(produto1).isNotEqualTo(produto2);
  }

  @Test
  void testNotEqualsWithNull() {
    Produto produto = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), new Categoria(1L, "Categoria Teste"), "imagemUrl");
    assertThat(produto).isNotEqualTo(null);
  }

  @Test
  void testNotEqualsWithDifferentClass() {
    Produto produto = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), new Categoria(1L, "Categoria Teste"), "imagemUrl");
    Object other = new Object();
    assertThat(produto).isNotEqualTo(other);
  }

  @Test
  void testHashCodeConsistency() {
    Produto produto = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), new Categoria(1L, "Categoria Teste"), "imagemUrl");
    int initialHashCode = produto.hashCode();
    assertThat(produto.hashCode()).isEqualTo(initialHashCode);
  }

  @Test
  void testHashCodeEqualityForEqualObjects() {
    UUID id = UUID.fromString("4b307306-7b8f-4b42-b887-aa68288398b8");
    Categoria categoria =  new Categoria(1L, "Categoria Teste");
    BigDecimal valor = new BigDecimal("10.0");

    Produto produto1 = new Produto(id, "Produto Teste", "Descrição", valor, categoria, "imagemUrl");
    Produto produto2 = new Produto(id, "Produto Teste", "Descrição", valor, categoria, "imagemUrl");
    assertThat(produto1.hashCode()).hasSameHashCodeAs(produto2.hashCode());
  }

  @Test
  void testHashCodeInequalityForUnequalObjects() {
    Produto produto1 = new Produto(UUID.randomUUID(), "Produto Teste", "Descrição", new BigDecimal("10.0"), new Categoria(1L, "Categoria Teste"), "imagemUrl");
    Produto produto2 = new Produto(UUID.randomUUID(), "Outro Produto", "Outra Descrição", new BigDecimal("20.0"), new Categoria(2L, "Outra Categoria"), "outraImagemUrl");
    assertThat(produto1.hashCode()).isNotEqualTo(produto2.hashCode());
  }

  @Test
  void deveCriarProdutoComTodosOsAtributos() {
    String nome = "Produto Teste";
    String descricao = "Descrição do Produto Teste";
    BigDecimal valor = new BigDecimal("10.0");
    Categoria categoria = new Categoria(1L, "Categoria Teste");
    String imagemUrl = "http://imagem.url/produto.jpg";

    Produto produto = new Produto(nome, descricao, valor, categoria, imagemUrl);

    assertThat(produto.getNome()).isEqualTo(nome);
    assertThat(produto.getDescricao()).isEqualTo(descricao);
    assertThat(produto.getValor()).isEqualByComparingTo(valor);
    assertThat(produto.getCategoria()).isEqualTo(categoria);
    assertThat(produto.getImagemUrl()).isEqualTo(imagemUrl);
  }

  @Test
  void deveAdicionarCategoriaAoProduto() {
    UUID id = UUID.randomUUID();
    Produto produto = new Produto(id, "Produto Teste", "Descrição do Produto Teste", new BigDecimal("10.0"), null, "http://imagem.url/produto.jpg");
    Categoria categoria = new Categoria(1L, "Categoria Teste");

    Produto produtoComCategoria = produto.adicionarCategoria(produto, categoria);

    assertThat(produtoComCategoria.getId()).isEqualTo(produto.getId());
    assertThat(produtoComCategoria.getNome()).isEqualTo(produto.getNome());
    assertThat(produtoComCategoria.getDescricao()).isEqualTo(produto.getDescricao());
    assertThat(produtoComCategoria.getValor()).isEqualByComparingTo(produto.getValor());
    assertThat(produtoComCategoria.getCategoria().getId()).isEqualTo(categoria.getId());
    assertThat(produtoComCategoria.getCategoria().getDescricao()).isEqualTo(categoria.getDescricao());
    assertThat(produtoComCategoria.getImagemUrl()).isEqualTo(produto.getImagemUrl());
  }

  @Test
  void listarProdutosPorListaDeIdsComSucesso() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());
    ProdutoEntity produtoEntity1 = new ProdutoEntity();
    ProdutoEntity produtoEntity2 = new ProdutoEntity();
    Produto produto1 = new Produto(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, null, "imagem1.jpg");
    Produto produto2 = new Produto(UUID.randomUUID(), "Produto 2", "Descrição 2", BigDecimal.valueOf(20), null, "imagem2.jpg");

    when(produtoRepositoryJPA.findAllById(uuids)).thenReturn(Arrays.asList(produtoEntity1, produtoEntity2));
    when(produtoEntityMapper.toProduto(produtoEntity1)).thenReturn(produto1);
    when(produtoEntityMapper.toProduto(produtoEntity2)).thenReturn(produto2);

    List<Produto> result = produtoRepositoryImpl.listarProdutosPorListaDeIds(uuids);

    assertThat(result).hasSize(2).containsExactlyInAnyOrder(produto1, produto2);
  }

  @Test
  void listarProdutosPorListaDeIdsRetornaNotFoundQuandoListaVazia() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());

    when(produtoRepositoryJPA.findAllById(uuids)).thenReturn(List.of());

    assertThatThrownBy(() -> produtoRepositoryImpl.listarProdutosPorListaDeIds(uuids))
            .isInstanceOf(NotFoundException.class)
            .hasMessage("Não foram encontrados produtos!");
  }

  @Test
  void toProdutoEntityReturnsNullWhenProdutoIsNull() {

    ProdutoEntity result = produtoEntityMapper.toProdutoEntity(null);

    assertThat(result).isNull();
  }

  @Test
  void listarProdutosPorListaDeIdsRetornaNotFoundQuandoTodosProdutosSaoNulos() {
    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());
    ProdutoEntity produtoEntity1 = new ProdutoEntity();
    ProdutoEntity produtoEntity2 = new ProdutoEntity();

    when(produtoRepositoryJPA.findAllById(uuids)).thenReturn(Arrays.asList(produtoEntity1, produtoEntity2));
    when(produtoEntityMapper.toProduto(produtoEntity1)).thenReturn(null);
    when(produtoEntityMapper.toProduto(produtoEntity2)).thenReturn(null);

    assertThatThrownBy(() -> produtoRepositoryImpl.listarProdutosPorListaDeIds(uuids))
            .isInstanceOf(NotFoundException.class)
            .hasMessage("Não foram encontrados produtos!");
  }
}