package br.com.fiap.fiapeats.core.usecases.produto;

import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.produto.ListarProdutosUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import java.util.List;

public class ListarProdutosUseCaseImpl implements ListarProdutosUseCasePort {

  private final ProdutoRepositoryPort produtoRepositoryPort;

  public ListarProdutosUseCaseImpl(ProdutoRepositoryPort produtoRepositoryPort) {
    this.produtoRepositoryPort = produtoRepositoryPort;
  }

  @Override
  public List<Produto> listarProdutos() {
    return produtoRepositoryPort.listarProdutos();
  }
}
