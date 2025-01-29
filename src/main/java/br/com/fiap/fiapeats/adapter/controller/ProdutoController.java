package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.ProdutoPresenter;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.*;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller class for managing Produto operations.
 * Provides methods to create, edit, delete, and list products.
 */
public class ProdutoController {

  private final CriarProdutoUseCase criarProdutoUseCase;
  private final EditarProdutoUseCase editarProdutoUseCase;
  private final ExcluirProdutoUseCase excluirProdutoUseCase;
  private final ListarProdutosUseCase listarProdutos;
  private final ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase;
  private final ListarProdutosPorListaDeIdsUseCase listarProdutosPorListaDeIdsUseCase;

  /**
   * Constructs a new ProdutoController.
   *
   * @param criarProdutoUseCase the use case for creating products
   * @param editarProdutoUseCase the use case for editing products
   * @param excluirProdutoUseCase the use case for deleting products
   * @param listarProdutos the use case for listing all products
   * @param listarProdutosPorCategoriaUseCase the use case for listing products by category
   * @param listarProdutosPorListaDeIdsUseCase the use case for listing products by a list of IDs
   */
  public ProdutoController(
          CriarProdutoUseCase criarProdutoUseCase,
          EditarProdutoUseCase editarProdutoUseCase,
          ExcluirProdutoUseCase excluirProdutoUseCase,
          ListarProdutosUseCase listarProdutos,
          ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase,
          ListarProdutosPorListaDeIdsUseCase listarProdutosPorListaDeIdsUseCase) {
    this.criarProdutoUseCase = criarProdutoUseCase;
    this.editarProdutoUseCase = editarProdutoUseCase;
    this.excluirProdutoUseCase = excluirProdutoUseCase;
    this.listarProdutos = listarProdutos;
    this.listarProdutosPorCategoriaUseCase = listarProdutosPorCategoriaUseCase;
    this.listarProdutosPorListaDeIdsUseCase = listarProdutosPorListaDeIdsUseCase;
  }

  /**
   * Creates a new product.
   *
   * @param criarProdutoDTO the DTO containing product creation data
   * @return the response DTO with the created product data
   */
  public CriarProdutoResponse criarProduto(CriarProdutoDTO criarProdutoDTO) {
    Produto produto = criarProdutoUseCase.criar(criarProdutoDTO);
    return ProdutoPresenter.toCriarProdutoResponse(produto);
  }

  /**
   * Edits an existing product.
   *
   * @param editarProdutoDTO the DTO containing product editing data
   * @return the response DTO with the edited product data
   */
  public EditarProdutoResponse editarProduto(EditarProdutoDTO editarProdutoDTO) {
    Produto produto = editarProdutoUseCase.editar(editarProdutoDTO);
    return ProdutoPresenter.toEditarProdutoResponse(produto);
  }

  /**
   * Deletes a product by its ID.
   *
   * @param id the UUID of the product to be deleted
   */
  public void removerProduto(UUID id) {
    excluirProdutoUseCase.excluir(id);
  }

  /**
   * Lists all products.
   *
   * @return the list of response DTOs with all products
   */
  public List<ProdutoResponse> listarTodosProdutos() {
    List<Produto> produtos = listarProdutos.listarProdutos();
    return ProdutoPresenter.toProdutosResponse(produtos);
  }

  /**
   * Lists products by category ID.
   *
   * @param idCategoria the ID of the category to filter products by
   * @return the list of response DTOs with products in the specified category
   */
  public List<ProdutoResponse> consultarProdutoPorCategoria(String idCategoria) {
    List<Produto> produtos = listarProdutosPorCategoriaUseCase.listarProdutosPorCategoria(idCategoria);
    return ProdutoPresenter.toProdutosResponse(produtos);
  }

  /**
   * Lists products by a list of UUIDs.
   *
   * @param uuids the list of UUIDs to filter products by
   * @return the list of response DTOs with products corresponding to the provided UUIDs
   */
  public List<ProdutoResponse> listarProdutosPorListaDeIds(List<UUID> uuids) {
    List<Produto> produto = listarProdutosPorListaDeIdsUseCase.listarProdutosPorListaDeIdsUseCase(uuids);
    return ProdutoPresenter.toProdutosResponse(produto);
  }
}