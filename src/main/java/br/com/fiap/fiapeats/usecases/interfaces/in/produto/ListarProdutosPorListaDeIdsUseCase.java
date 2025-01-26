package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;

import java.util.List;
import java.util.UUID;

/**
 * Use case interface for listing products by a list of UUIDs.
 */
public interface ListarProdutosPorListaDeIdsUseCase {

  /**
   * Lists products by a list of UUIDs.
   *
   * @param uuids the list of UUIDs
   * @return the list of products corresponding to the given UUIDs
   */
  List<Produto> ListarProdutosPorListaDeIdsUseCase(List<UUID> uuids);
}