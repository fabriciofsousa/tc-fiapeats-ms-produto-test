package br.com.fiap.fiapeats.domain.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.domain.usecases.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.domain.interfaces.in.produto.CriarProdutoUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.categoria.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.domain.interfaces.out.produto.ProdutoRepositoryInterface;

public class CriarProdutoUseCaseImpl implements CriarProdutoUseCase {

  private final ProdutoRepositoryInterface produtoRepositoryInterface;

  private final CategoriaRepositoryInterface categoriaRepositoryInterface;

  public CriarProdutoUseCaseImpl(
      ProdutoRepositoryInterface produtoRepositoryInterface,
      CategoriaRepositoryInterface categoriaRepositoryInterface) {
    this.produtoRepositoryInterface = produtoRepositoryInterface;
    this.categoriaRepositoryInterface = categoriaRepositoryInterface;
  }

  @Override
  public Produto criar(Produto produto) {
    var categoria = categoriaRepositoryInterface.consultar(produto.getCategoria());

    if (categoria == null) {
      throw new CategoriaInvalidaException("Categoria informada inválida");
    }
    return produtoRepositoryInterface.salvar(produto.adicionarCategoria(produto, categoria));
  }
}
