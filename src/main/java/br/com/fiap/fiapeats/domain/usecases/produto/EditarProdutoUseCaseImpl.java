package br.com.fiap.fiapeats.domain.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.domain.usecases.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.domain.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.domain.interfaces.in.produto.EditarProdutoUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.categoria.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.domain.interfaces.out.produto.ProdutoRepositoryInterface;

public class EditarProdutoUseCaseImpl implements EditarProdutoUseCase {

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
