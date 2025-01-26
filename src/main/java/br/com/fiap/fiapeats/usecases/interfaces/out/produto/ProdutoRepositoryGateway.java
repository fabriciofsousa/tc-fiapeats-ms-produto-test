package br.com.fiap.fiapeats.usecases.interfaces.out.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;

import java.util.List;
import java.util.UUID;

/**
 * Interface for the Produto Repository Gateway.
 * Provides methods for CRUD operations and specific queries related to Produto entities.
 */
public interface ProdutoRepositoryGateway {

  /**
   * Saves a new Produto entity.
   *
   * @param produto the Produto entity to be saved
   * @return the saved Produto entity
   */
  Produto salvar(Produto produto);

  /**
   * Edits an existing Produto entity.
   *
   * @param produto the Produto entity to be edited
   * @return the edited Produto entity
   */
  Produto editar(Produto produto);

  /**
   * Consults a Produto entity by its ID.
   *
   * @param id the UUID of the Produto entity
   * @return the consulted Produto entity
   */
  Produto consultarPorId(UUID id);


  /**
   * Deletes a Produto entity by its ID.
   *
   * @param id the UUID of the Produto entity to be deleted
   */
  void excluir(UUID id);

  /**
   * Lists all Produto entities.
   *
   * @return the list of all Produto entities
   */
  List<Produto> listarProdutos();

  /**
   * Lists Produto entities by their category ID.
   *
   * @param idCategoria the ID of the category
   * @return the list of Produto entities in the specified category
   */
  List<Produto> listarProdutosPorCategoria(Long idCategoria);


  /**
   * Lists Produto entities by a list of UUIDs.
   *
   * @param uuids the list of UUIDs
   * @return the list of Produto entities
   */
  List<Produto> listarProdutosPorListaDeIds(List<UUID> uuids);
}