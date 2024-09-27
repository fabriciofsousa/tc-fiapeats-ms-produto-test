package br.com.fiap.fiapeats.domain.usecases.produto;

import br.com.fiap.fiapeats.domain.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.domain.interfaces.in.produto.ExcluirProdutoUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.produto.ProdutoRepositoryInterface;
import java.util.UUID;

public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCase {

  private final ProdutoRepositoryInterface produtoRepositoryInterface;

  public ExcluirProdutoUseCaseImpl(ProdutoRepositoryInterface produtoRepositoryInterface) {
    this.produtoRepositoryInterface = produtoRepositoryInterface;
  }

  @Override
  public void excluir(UUID id) {

    if (produtoRepositoryInterface.consultarPorId(id) == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    produtoRepositoryInterface.excluir(id);
  }
}
