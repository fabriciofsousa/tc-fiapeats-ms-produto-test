package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ListarProdutosPorCategoriaUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import java.util.List;

/**
 * Implementation of the ListarProdutosPorCategoriaUseCase interface.
 */
public class ListarProdutosPorCategoriaUseCaseImpl implements ListarProdutosPorCategoriaUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;
  private final CategoriaRepositoryGateway categoriaRepositoryGateway;

  /**
   * Constructs a new ListarProdutosPorCategoriaUseCaseImpl with the specified repository gateways.
   *
   * @param produtoRepositoryGateway the repository gateway to access product data
   * @param categoriaRepositoryGateway the repository gateway to access category data
   */
  public ListarProdutosPorCategoriaUseCaseImpl(
          ProdutoRepositoryGateway produtoRepositoryGateway,
          CategoriaRepositoryGateway categoriaRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
    this.categoriaRepositoryGateway = categoriaRepositoryGateway;
  }

  /**
   * Lists products by the specified category.
   *
   * @param categoria the category to filter products by
   * @return the list of products in the specified category
   * @throws NotFoundException if the category is not found
   */
  @Override
  public List<Produto> listarProdutosPorCategoria(String categoria) {
    Categoria cat = categoriaRepositoryGateway.consultar(new Categoria(null, categoria));
    if (cat == null) throw new NotFoundException("Categoria " + categoria + " não encontrada!");

    return produtoRepositoryGateway.listarProdutosPorCategoria(cat.getId());
  }
}