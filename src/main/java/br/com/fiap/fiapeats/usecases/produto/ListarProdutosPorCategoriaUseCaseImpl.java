package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ListarProdutosPorCategoriaUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import java.util.List;

public class ListarProdutosPorCategoriaUseCaseImpl
    implements ListarProdutosPorCategoriaUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;
  private final CategoriaRepositoryGateway categoriaRepositoryGateway;

  public ListarProdutosPorCategoriaUseCaseImpl(
      ProdutoRepositoryGateway produtoRepositoryGateway,
      CategoriaRepositoryGateway categoriaRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
    this.categoriaRepositoryGateway = categoriaRepositoryGateway;
  }

  @Override
  public List<Produto> listarProdutosPorCategoria(String categoria) {
    Categoria cat = categoriaRepositoryGateway.consultar(new Categoria(null, categoria));
    if (cat == null)
      throw new NotFoundException("Categoria " + categoria + " não encontrada!");

    return produtoRepositoryGateway.listarProdutosPorcategoria(cat.getId());
  }
}
