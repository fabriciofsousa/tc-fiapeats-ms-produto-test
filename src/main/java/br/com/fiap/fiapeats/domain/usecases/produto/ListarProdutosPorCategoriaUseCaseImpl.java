package br.com.fiap.fiapeats.domain.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.domain.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.domain.interfaces.in.produto.ListarProdutosPorCategoriaUseCase;
import br.com.fiap.fiapeats.domain.interfaces.out.categoria.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.domain.interfaces.out.produto.ProdutoRepositoryInterface;
import java.util.List;

public class ListarProdutosPorCategoriaUseCaseImpl
    implements ListarProdutosPorCategoriaUseCase {

  private final ProdutoRepositoryInterface produtoRepositoryInterface;
  private final CategoriaRepositoryInterface categoriaRepositoryInterface;

  public ListarProdutosPorCategoriaUseCaseImpl(
      ProdutoRepositoryInterface produtoRepositoryInterface,
      CategoriaRepositoryInterface categoriaRepositoryInterface) {
    this.produtoRepositoryInterface = produtoRepositoryInterface;
    this.categoriaRepositoryInterface = categoriaRepositoryInterface;
  }

  @Override
  public List<Produto> listarProdutosPorCategoria(String categoria) {
    Categoria cat = categoriaRepositoryInterface.consultar(new Categoria(null, categoria));
    if (cat == null)
      throw new NotFoundException("Categoria " + categoria + " não encontrada!");

    return produtoRepositoryInterface.listarProdutosPorcategoria(cat.getId());
  }
}
