package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.interfaces.in.produto.ExcluirProdutoUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.ProdutoRepositoryInterface;
import java.util.UUID;

public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCaseInterface {

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
