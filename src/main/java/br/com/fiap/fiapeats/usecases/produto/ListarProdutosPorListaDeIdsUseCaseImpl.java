package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ListarProdutosPorListaDeIdsUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;

import java.util.List;
import java.util.UUID;


public class ListarProdutosPorListaDeIdsUseCaseImpl implements ListarProdutosPorListaDeIdsUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;


  public ListarProdutosPorListaDeIdsUseCaseImpl(ProdutoRepositoryGateway produtoRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
  }

  /**
   * Lists products by a list of UUIDs.
   *
   * @param uuids the list of UUIDs to filter products by
   * @return the list of products corresponding to the provided UUIDs
   */
  @Override
  public List<Produto> ListarProdutosPorListaDeIdsUseCase(List<UUID> uuids) {
    return produtoRepositoryGateway.listarProdutosPorListaDeIds(uuids);
  }
}