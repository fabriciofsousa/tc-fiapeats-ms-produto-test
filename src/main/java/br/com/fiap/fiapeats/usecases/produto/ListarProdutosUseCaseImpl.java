package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ListarProdutosUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import java.util.List;

/**
 * Implementation of the ListarProdutosUseCase interface.
 */
public class ListarProdutosUseCaseImpl implements ListarProdutosUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;

  /**
   * Constructs a new ListarProdutosUseCaseImpl with the specified repository gateway.
   *
   * @param produtoRepositoryGateway the repository gateway to access product data
   */
  public ListarProdutosUseCaseImpl(ProdutoRepositoryGateway produtoRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
  }

  /**
   * Lists all products by delegating to the repository gateway.
   *
   * @return the list of all products
   */
  @Override
  public List<Produto> listarProdutos() {
    return produtoRepositoryGateway.listarProdutos();
  }
}