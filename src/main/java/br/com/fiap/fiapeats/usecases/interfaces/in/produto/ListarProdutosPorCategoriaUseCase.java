package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import java.util.List;

/**
 * Use case interface for listing products by category.
 */
public interface ListarProdutosPorCategoriaUseCase {

  /**
   * Lists products by the specified category.
   *
   * @param categoria the category to filter products by
   * @return the list of products in the specified category
   */
  List<Produto> listarProdutosPorCategoria(String categoria);
}