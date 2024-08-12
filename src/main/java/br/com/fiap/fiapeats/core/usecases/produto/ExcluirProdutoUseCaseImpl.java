package br.com.fiap.fiapeats.core.usecases.produto;

import br.com.fiap.fiapeats.core.exceptions.NotFoundException;
import br.com.fiap.fiapeats.core.ports.in.produto.ExcluirProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import java.util.UUID;

public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCasePort {

  private final ProdutoRepositoryPort produtoRepositoryPort;

  public ExcluirProdutoUseCaseImpl(ProdutoRepositoryPort produtoRepositoryPort) {
    this.produtoRepositoryPort = produtoRepositoryPort;
  }

  @Override
  public void excluir(UUID id) {

    if (produtoRepositoryPort.consultarPorId(id) == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    produtoRepositoryPort.excluir(id);
  }
}
