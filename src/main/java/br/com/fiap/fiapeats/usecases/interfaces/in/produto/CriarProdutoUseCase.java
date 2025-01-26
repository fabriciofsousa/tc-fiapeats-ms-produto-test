package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;

/**
 * Use case interface for creating a product.
 */
public interface CriarProdutoUseCase {

  /**
   * Creates a product based on the provided DTO.
   *
   * @param criarProdutoDTO the DTO containing the product details to be created
   * @return the created product
   */
  Produto criar(CriarProdutoDTO criarProdutoDTO);
}