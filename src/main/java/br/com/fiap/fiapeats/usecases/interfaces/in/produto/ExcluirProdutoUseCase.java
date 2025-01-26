package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import java.util.UUID;

/**
 * Use case interface for deleting a product.
 */
public interface ExcluirProdutoUseCase {

  /**
   * Deletes a product by its ID.
   *
   * @param id the UUID of the product to be deleted
   */
  void excluir(UUID id);
}