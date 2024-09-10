package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.entities.Categoria;
import br.com.fiap.fiapeats.entities.Produto;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.interfaces.in.produto.ListarProdutosPorCategoriaUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.categoria.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.interfaces.out.produto.ProdutoRepositoryInterface;
import java.util.List;

public class ListarProdutosPorCategoriaUseCaseImpl
    implements ListarProdutosPorCategoriaUseCaseInterface {

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
