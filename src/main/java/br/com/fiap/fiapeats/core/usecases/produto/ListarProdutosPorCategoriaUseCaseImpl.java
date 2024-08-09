package br.com.fiap.fiapeats.core.usecases.produto;

import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.exceptions.NotFoundException;
import br.com.fiap.fiapeats.core.ports.in.produto.ListarProdutosPorCategoriaUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import java.util.List;

public class ListarProdutosPorCategoriaUseCaseImpl
    implements ListarProdutosPorCategoriaUseCasePort {

  private final ProdutoRepositoryPort produtoRepositoryPort;
  private final CategoriaRepositoryPort categoriaRepositoryPort;

  public ListarProdutosPorCategoriaUseCaseImpl(
      ProdutoRepositoryPort produtoRepositoryPort,
      CategoriaRepositoryPort categoriaRepositoryPort) {
    this.produtoRepositoryPort = produtoRepositoryPort;
    this.categoriaRepositoryPort = categoriaRepositoryPort;
  }

  @Override
  public List<Produto> listarProdutosPorCategoria(String categoria) {
    Categoria cat = categoriaRepositoryPort.consultar(new Categoria(null, categoria));
    if (cat == null)
      throw new NotFoundException("Categoria " + categoria + " não encontrada!");

    return produtoRepositoryPort.listarProdutosPorcategoria(cat.getId());
  }
}
