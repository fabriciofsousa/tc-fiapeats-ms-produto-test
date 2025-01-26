package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;

/**
 * Use case interface for editing a product.
 */
public interface EditarProdutoUseCase {

  /**
   * Edits a product based on the provided DTO.
   *
   * @param editarProdutoDTO the DTO containing the product details to be edited
   * @return the edited product
   */
  Produto editar(EditarProdutoDTO editarProdutoDTO);
}