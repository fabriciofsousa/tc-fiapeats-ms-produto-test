package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ExcluirProdutoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import java.util.UUID;

public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;

  public ExcluirProdutoUseCaseImpl(ProdutoRepositoryGateway produtoRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
  }

  @Override
  public void excluir(UUID id) {

    if (produtoRepositoryGateway.consultarPorId(id) == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    produtoRepositoryGateway.excluir(id);
  }
}
