package br.com.fiap.fiapeats.domain.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.domain.interfaces.in.produto.ListarProdutosUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.produto.ProdutoRepositoryInterface;
import java.util.List;

public class ListarProdutosUseCaseImpl implements ListarProdutosUseCase {

  private final ProdutoRepositoryInterface produtoRepositoryInterface;

  public ListarProdutosUseCaseImpl(ProdutoRepositoryInterface produtoRepositoryInterface) {
    this.produtoRepositoryInterface = produtoRepositoryInterface;
  }

  @Override
  public List<Produto> listarProdutos() {
    return produtoRepositoryInterface.listarProdutos();
  }
}
