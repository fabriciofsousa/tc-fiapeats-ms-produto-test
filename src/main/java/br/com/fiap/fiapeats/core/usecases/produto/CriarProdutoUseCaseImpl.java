package br.com.fiap.fiapeats.core.usecases.produto;

import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.core.ports.in.produto.CriarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;

public class CriarProdutoUseCaseImpl implements CriarProdutoUseCasePort {

  private final ProdutoRepositoryPort produtoRepositoryPort;

  private final CategoriaRepositoryPort categoriaRepositoryPort;

  public CriarProdutoUseCaseImpl(
      ProdutoRepositoryPort produtoRepositoryPort,
      CategoriaRepositoryPort categoriaRepositoryPort) {
    this.produtoRepositoryPort = produtoRepositoryPort;
    this.categoriaRepositoryPort = categoriaRepositoryPort;
  }

  @Override
  public Produto criar(Produto produto) {
    var categoria = categoriaRepositoryPort.consultar(produto.getCategoria());

    if (categoria == null) {
      throw new CategoriaInvalidaException("Categoria informada inválida");
    }
    return produtoRepositoryPort.salvar(produto.adicionarCategoria(produto, categoria));
  }
}
