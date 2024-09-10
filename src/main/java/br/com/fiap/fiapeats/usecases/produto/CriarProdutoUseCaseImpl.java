package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.entities.Produto;
import br.com.fiap.fiapeats.usecases.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.interfaces.in.produto.CriarProdutoUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.interfaces.out.ProdutoRepositoryInterface;

public class CriarProdutoUseCaseImpl implements CriarProdutoUseCaseInterface {

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
