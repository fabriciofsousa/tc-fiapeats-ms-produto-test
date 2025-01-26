package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ExcluirProdutoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import java.util.UUID;

/**
 * Implementation of the ExcluirProdutoUseCase interface.
 */
public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;

  /**
   * Constructs a new ExcluirProdutoUseCaseImpl with the specified repository gateway.
   *
   * @param produtoRepositoryGateway the repository gateway to access product data
   */
  public ExcluirProdutoUseCaseImpl(ProdutoRepositoryGateway produtoRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
  }

  /**
   * Deletes a product by its ID.
   *
   * @param id the UUID of the product to be deleted
   * @throws NotFoundException if the product is not found
   */
  @Override
  public void excluir(UUID id) {

    if (produtoRepositoryGateway.consultarPorId(id) == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    produtoRepositoryGateway.excluir(id);
  }
}