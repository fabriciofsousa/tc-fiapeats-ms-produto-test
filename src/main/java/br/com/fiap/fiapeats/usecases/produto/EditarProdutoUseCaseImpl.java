package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.entities.Produto;
import br.com.fiap.fiapeats.usecases.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.interfaces.in.produto.EditarProdutoUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.interfaces.out.ProdutoRepositoryInterface;

public class EditarProdutoUseCaseImpl implements EditarProdutoUseCaseInterface {

  private final ProdutoRepositoryInterface produtoRepositoryInterface;

  private final CategoriaRepositoryInterface categoriaRepositoryInterface;

  public EditarProdutoUseCaseImpl(
      ProdutoRepositoryInterface produtoRepositoryInterface,
      CategoriaRepositoryInterface categoriaRepositoryInterface) {
    this.produtoRepositoryInterface = produtoRepositoryInterface;
    this.categoriaRepositoryInterface = categoriaRepositoryInterface;
  }

  @Override
  public Produto editar(Produto produto) {

    var produtoConsultado = produtoRepositoryInterface.consultarPorId(produto.getId());

    if (produtoConsultado == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    var categoria = categoriaRepositoryInterface.consultar(produto.getCategoria());

    if (categoria == null) {
      throw new CategoriaInvalidaException("Categoria informada inválida");
    }

    return produtoRepositoryInterface.editar(produto.adicionarCategoria(produto, categoria));
  }
}
