package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.entities.Produto;
import br.com.fiap.fiapeats.interfaces.in.produto.ListarProdutosUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.ProdutoRepositoryInterface;
import java.util.List;

public class ListarProdutosUseCaseImpl implements ListarProdutosUseCaseInterface {

  private final ProdutoRepositoryInterface produtoRepositoryInterface;

  public ListarProdutosUseCaseImpl(ProdutoRepositoryInterface produtoRepositoryInterface) {
    this.produtoRepositoryInterface = produtoRepositoryInterface;
  }

  @Override
  public List<Produto> listarProdutos() {
    return produtoRepositoryInterface.listarProdutos();
  }
}
